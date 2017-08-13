package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import ly.phenoma.task.constant.input.JsonFields;
import org.springframework.stereotype.Component;

@Component(value = JsonFields.RIMS + "17")
public class Wheel17 extends Wheel {

    @Override
    public String catalogName() {
        return CatalogNames.RIMS_17;
    }
}
