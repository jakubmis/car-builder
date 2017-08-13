package ly.phenoma.task.model.car;

import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.display.Display;
import ly.phenoma.task.model.engine.Engine;
import ly.phenoma.task.model.interior.Interior;
import ly.phenoma.task.model.transmission.Transmission;
import ly.phenoma.task.model.utils.Color;
import ly.phenoma.task.model.wheel.Wheel;

import java.util.List;
import java.util.Optional;

/**
 * Car interface presents all basic operation which every car should have.
 */
public interface Car {

    float price();

    List<Item> getItems();

    Color getColor();

    String getName();

    default Transmission getTransmission() {
        return getItems().stream()
                .filter(element -> element instanceof Transmission)
                .map(element -> (Transmission) element)
                .findAny()
                .orElse(null);
    }

    default Wheel getWheel() {
        return getItems().stream()
                .filter(element -> element instanceof Wheel)
                .map(element -> (Wheel) element)
                .findAny()
                .orElse(null);
    }

    default Interior getInterior() {
        return getItems().stream()
                .filter(element -> element instanceof Interior)
                .map(element -> (Interior) element)
                .findAny()
                .orElse(null);
    }

    default Engine getEngine() {
        return getItems().stream()
                .filter(element -> element instanceof Engine)
                .map(element -> (Engine) element)
                .findAny()
                .orElse(null);
    }

    default Optional<Display> getDisplay() {
        return getItems().stream()
                .filter(element -> element instanceof Display)
                .map(element -> (Display) element)
                .findAny();
    }

    default boolean isValid() {
        return getItems().stream().anyMatch(element -> element instanceof Engine) &&
                getItems().stream().anyMatch(element -> element instanceof Transmission) &&
                getItems().stream().anyMatch(element -> element instanceof Wheel) &&
                getItems().stream().anyMatch(element -> element instanceof Interior);
    }

    int numberOfDoors();

}
