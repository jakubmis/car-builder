package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import ly.phenoma.task.constant.input.JsonFields;
import org.springframework.stereotype.Component;

@Component(value = JsonFields.RIMS + "16")
public class Wheel16 extends Wheel {

    @Override
    public String catalogName() {
        return CatalogNames.RIMS_16;
    }

}
