package ly.phenoma.task.configurator;

import ly.phenoma.task.factory.AudiFactory;
import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.car.BasicCar;
import ly.phenoma.task.model.car.Car;
import ly.phenoma.task.model.utils.Color;
import ly.phenoma.task.utils.JsonHelper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static ly.phenoma.task.constant.input.JsonFields.COLOR;
import static ly.phenoma.task.constant.input.JsonFields.NAME;
import static ly.phenoma.task.utils.JsonValidator.isValid;

/**
 * AudiConfigurator class is main processing object for application. For every configure method invocation,
 * class should refresh PriceCatalog and SatisfactionCatalog. Class also invokes JsonValidator validation for
 * inputted String. Using AudiFactory and ItemConfigurator it tries to build Car object.
 */
@Component
public class AudiConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AudiConfigurator.class);

    private final PriceCatalog priceCatalog;
    private final SatisfactionCatalog satisfactionCatalog;
    private final AudiFactory audiFactory;
    private final ItemConfigurator itemConfigurator;

    @Autowired
    public AudiConfigurator(PriceCatalog priceCatalog, SatisfactionCatalog satisfactionCatalog, AudiFactory audiFactory,
                            ItemConfigurator itemConfigurator) {
        this.priceCatalog = priceCatalog;
        this.satisfactionCatalog = satisfactionCatalog;
        this.audiFactory = audiFactory;
        this.itemConfigurator = itemConfigurator;
    }

    public Optional<Car> configure(String json) {
        boolean valid = isValid(json);
        boolean pricesRefreshed = refreshPricesCatalog();
        boolean satisfactionRefreshed = refreshSatisfactionCatalog();
        if (valid && pricesRefreshed && satisfactionRefreshed) {
            return buildCar(new JSONObject(json));
        }
        LOGGER.info("Can't configure car because of errors");
        return Optional.empty();
    }

    private boolean refreshSatisfactionCatalog() {
        return satisfactionCatalog.load("satisfactionCatalog.csv");
    }

    private boolean refreshPricesCatalog() {
        return priceCatalog.load("pricingCatalog.csv");
    }

    private Optional<Car> buildCar(JSONObject jsonCar) {
        String carType = getCarType(jsonCar);
        JSONObject unwrappedJsonCar = unwrapJsonCar(jsonCar, carType);
        BasicCar basicCar = buildBasicCar(unwrappedJsonCar);
        if (basicCar.isValid()) {
            return buildAudi(carType, basicCar);
        }
        LOGGER.info("Base car is not valid");
        return Optional.empty();
    }

    private String getCarType(JSONObject jsonCar) {
        return jsonCar.keys().next();
    }

    private JSONObject unwrapJsonCar(JSONObject jsonCar, String carType) {
        return jsonCar.getJSONObject(carType);
    }

    private Optional<Car> buildAudi(String carType, BasicCar basicCar) {
        return audiFactory
                .get(carType, basicCar);
    }

    private BasicCar buildBasicCar(JSONObject unwrappedJsonCar) {
        List<Item> items = itemConfigurator.getCarComponents(unwrappedJsonCar);
        String color = JsonHelper.getField(unwrappedJsonCar, COLOR);
        String carName = JsonHelper.getField(unwrappedJsonCar, NAME);

        return BasicCar
                .builder()
                .color(Optional.ofNullable(color).map(Color::new).orElse(null))
                .name(carName)
                .items(items)
                .build();
    }

}
