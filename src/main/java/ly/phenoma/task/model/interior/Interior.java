package ly.phenoma.task.model.interior;

import lombok.Getter;
import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.base.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static ly.phenoma.task.constant.catalog.CatalogNames.INTERIOR;

@Getter
public abstract class Interior implements Item {

    private List<String> elements = new ArrayList<>();

    @Autowired
    private PriceCatalog priceCatalog;

    @Override
    public float price() {
        return elements.stream()
                .map(element -> priceCatalog.getPrices().get(element))
                .reduce(0f, Float::sum);
    }

    @Override
    public String catalogName() {
        return INTERIOR;
    }
}
