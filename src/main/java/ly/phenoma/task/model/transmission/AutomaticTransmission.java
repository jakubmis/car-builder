package ly.phenoma.task.model.transmission;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.input.JsonFields.TRANSMISSION;

@Component(value = TRANSMISSION + "automatic")
public class AutomaticTransmission extends Transmission {

    @Override
    public String catalogName() {
        return CatalogNames.AUTOMATIC_TRANSMISSION;
    }
}
