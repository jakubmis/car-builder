package ly.phenoma.task.model.display;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.IPS;

@Component
@Scope(value = "prototype")
public class IPSDisplay extends Display {

    public IPSDisplay(float value) {
        super(value);
    }

    @Override
    public String catalogName() {
        return IPS;
    }
}
