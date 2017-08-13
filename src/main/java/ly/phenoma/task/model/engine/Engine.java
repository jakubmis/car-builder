package ly.phenoma.task.model.engine;

import lombok.Getter;
import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class Engine implements Item {

    @Autowired
    private PriceCatalog priceCatalog;
    private EngineParams engineParams;
    private static final String PARAMETER_SEPARATOR = "_";

    Engine(EngineParams engineParams) {
        this.engineParams = engineParams;
    }

    String params() {
        return PARAMETER_SEPARATOR +
                getEngineParams().getEngineCapacity().getValue() +
                PARAMETER_SEPARATOR +
                getEngineParams().getEngineHorsepower().getValue();
    }
}
