package ly.phenoma.task.model.engine;

import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.PETROL;


@Component
@Scope(value = "prototype")
public class PetrolEngine extends Engine {

    public PetrolEngine(EngineParams engineParams) {
        super(engineParams);
    }

    @Override
    public String catalogName() {
        return PETROL + params();
    }
}
