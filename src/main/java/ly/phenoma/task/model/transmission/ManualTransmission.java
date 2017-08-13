package ly.phenoma.task.model.transmission;

import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.MANUAL_TRANSMISSION;
import static ly.phenoma.task.constant.input.JsonFields.TRANSMISSION;

@Component(value = TRANSMISSION + "manual")
public class ManualTransmission extends Transmission {

    @Override
    public String catalogName() {
        return MANUAL_TRANSMISSION;
    }
}
