package ly.phenoma.task.model.transmission;

import lombok.Getter;
import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.base.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public abstract class Transmission implements Item {

    @Autowired
    private PriceCatalog priceCatalog;

}
