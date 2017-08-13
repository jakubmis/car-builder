package ly.phenoma.task.model.engine;

import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.DIESEL;

@Component
@Scope(value = "prototype")
public class DieselEngine extends Engine {

    public DieselEngine(EngineParams engineParams) {
        super(engineParams);
    }

    @Override
    public String catalogName() {
        return DIESEL + params();
    }

}
