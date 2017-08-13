package ly.phenoma.task.factory;

import lombok.Getter;
import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.interior.Interior;
import ly.phenoma.task.model.transmission.Transmission;
import ly.phenoma.task.model.wheel.Wheel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static ly.phenoma.task.constant.input.JsonFields.*;

/**
 * ItemFactory is abstract factory for construction of all Item implementations
 */
@Component
@Getter
public class ItemFactory {

    private Map<String, Wheel> wheelFactory;
    private Map<String, Transmission> transmissionFactory;
    private Map<String, Interior> interiorFactory;
    private EngineFactory engineFactory;
    private DisplayFactory displayFactory;

    @Autowired
    public ItemFactory(Map<String, Wheel> wheelFactory, Map<String, Transmission> transmissionFactory,
                       Map<String, Interior> interiorFactory, EngineFactory engineFactory, DisplayFactory displayFactory) {
        this.wheelFactory = wheelFactory;
        this.transmissionFactory = transmissionFactory;
        this.interiorFactory = interiorFactory;
        this.engineFactory = engineFactory;
        this.displayFactory = displayFactory;
    }

    public Optional<Item> get(String name, String value) {
        switch (name) {
            case RIMS:
                return Optional.ofNullable(wheelFactory.get(RIMS + value));
            case TRANSMISSION:
                return Optional.ofNullable(transmissionFactory.get(TRANSMISSION + value));
            case ENGINE:
                return Optional.ofNullable(engineFactory.get(new JSONObject(value)));
            case INTERIOR:
                return Optional.ofNullable(interiorFactory.get(INTERIOR + value));
            case LCD:
                return Optional.ofNullable(displayFactory.get(value));
            default:
                return Optional.empty();
        }
    }
}
