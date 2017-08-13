package ly.phenoma.task.factory;

import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.engine.DieselEngine;
import ly.phenoma.task.model.engine.Engine;
import ly.phenoma.task.model.engine.PetrolEngine;
import ly.phenoma.task.model.engine.parameters.EngineCapacity;
import ly.phenoma.task.model.engine.parameters.EngineHorsepower;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.input.JsonFields.*;

/**
 * EngineFactory is simple factory for construction of all Engine implementations.
 */
@Component
class EngineFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(EngineFactory.class);
    private final BeanFactory factory;
    private final PriceCatalog priceCatalog;

    @Autowired
    public EngineFactory(BeanFactory factory, PriceCatalog priceCatalog) {
        this.factory = factory;
        this.priceCatalog = priceCatalog;
    }


    public Engine get(JSONObject jsonEngine) {
        String type = getEngineType(jsonEngine);
        EngineParams engineParams = getEngineParams(jsonEngine);
        Engine engine;
        switch (type) {
            case DIESEL:
                engine = factory.getBean(DieselEngine.class, engineParams);
                break;
            case PETROL:
                engine = factory.getBean(PetrolEngine.class, engineParams);
                break;
            default:
                engine = null;
        }
        return validate(engine);
    }

    private Engine validate(Engine engine) {
        if (engine != null && priceCatalog.contains(engine.catalogName())) {
            return engine;
        } else {
            LOGGER.error("Engine has wrong parameters!");
            return null;
        }
    }

    private String getEngineType(JSONObject jsonEngine) {
        return jsonEngine.get(ENGINE_TYPE).toString();
    }

    private EngineParams getEngineParams(JSONObject jsonEngine) {
        String jsonEngineParams = jsonEngine.get(ENGINE_PARAMS).toString();
        JSONObject jsonObject = new JSONObject(jsonEngineParams);
        String capacity = String.valueOf(jsonObject.getDouble(ENGINE_CAPACITY));
        String horsepower = jsonObject.get(ENGINE_HORSEPOWER).toString();
        return new EngineParams(new EngineHorsepower(horsepower), new EngineCapacity(capacity));
    }

}
