package ly.phenoma.task.model.car;

import lombok.Builder;
import lombok.Getter;
import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.utils.Color;

import java.util.List;

/**
 * BasicCar class is responsible for holding information for every common car. It provides composite pattern for
 * every Item operation.
 */
@Builder
@Getter
public class BasicCar implements Car {

    private List<Item> items;
    private Color color;
    private String name;

    public float price() {
        return items
                .stream()
                .map(Item::price)
                .reduce(0f, Float::sum);
    }

    @Override
    public int numberOfDoors() {
        return 0;
    }

}
