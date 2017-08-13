package ly.phenoma.task.model.display;

import lombok.Getter;
import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.base.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public abstract class Display implements Item {

    @Autowired
    private PriceCatalog priceCatalog;

    private float value;

    Display(float value) {
        this.value = value;
    }
}
