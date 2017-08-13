package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import ly.phenoma.task.constant.input.JsonFields;
import org.springframework.stereotype.Component;

@Component(value = JsonFields.RIMS + "15")
public class Wheel15 extends Wheel {

    @Override
    public String catalogName() {
        return CatalogNames.RIMS_15;
    }

}
