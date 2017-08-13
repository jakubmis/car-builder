package ly.phenoma.task.configurator;

import ly.phenoma.task.factory.ItemFactory;
import ly.phenoma.task.model.base.Item;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ItemConfigurator class reads unwrapped JSONObject looking for item fields which are further delegate to
 * ItemFactory class. For each item field it returns Item object.
 */
@Component
class ItemConfigurator {

    private final ItemFactory itemFactory;

    @Autowired
    public ItemConfigurator(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    public List<Item> getCarComponents(JSONObject jsonComponents) {
        return jsonComponents
                .keySet()
                .stream()
                .map(name -> get(name, jsonComponents.get(name).toString()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<Item> get(String name, String value) {
        return itemFactory.get(name, value);
    }
}
