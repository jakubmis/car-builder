package ly.phenoma.task.configurator;

import ly.phenoma.task.utils.CsvParser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * PriceCatalog class is responsible for holding prices from resource file.
 */
@Component
public class PriceCatalog {

    private Map<String, Float> prices = new HashMap<>();

    public boolean load(String resourceName) {
        prices = CsvParser.load(resourceName);
        return !prices.isEmpty();
    }

    public Map<String, Float> getPrices() {
        return new HashMap<>(prices);
    }

    public boolean containsAll(Set<String> keys) {
        return prices.keySet().containsAll(keys);
    }

    public boolean contains(String key) {
        return prices.keySet().contains(key);
    }
}
