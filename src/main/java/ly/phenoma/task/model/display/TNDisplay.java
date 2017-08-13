package ly.phenoma.task.model.display;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.TN;

@Component
@Scope(value = "prototype")
public class TNDisplay extends Display {

    public TNDisplay(float value) {
        super(value);
    }

    @Override
    public String catalogName() {
        return TN;
    }

}
