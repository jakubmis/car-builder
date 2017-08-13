package ly.phenoma.task.model.wheel;

import lombok.Getter;
import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.base.Item;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class Wheel implements Item {

    @Autowired
    private PriceCatalog priceCatalog;

}
