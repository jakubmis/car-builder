package ly.phenoma.task.model.display;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.TFT;

@Component
@Scope(value = "prototype")
public class TFTDisplay extends Display {

    public TFTDisplay(float value) {
        super(value);
    }

    @Override
    public String catalogName() {
        return TFT;
    }
}
