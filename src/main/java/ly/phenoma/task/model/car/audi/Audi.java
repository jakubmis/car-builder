package ly.phenoma.task.model.car.audi;

import lombok.Getter;
import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.car.BasicCar;
import ly.phenoma.task.model.car.Car;
import ly.phenoma.task.model.utils.Color;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Getter
public abstract class Audi implements Car, Item {

    @Autowired
    private PriceCatalog priceCatalog;

    protected BasicCar car;

    Audi(BasicCar car) {
        this.car = car;
    }

    @Override
    public float price() {
        return car.price() + Item.super.price();
    }

    @Override
    public List<Item> getItems() {
        return car.getItems();
    }

    @Override
    public Color getColor() {
        return car.getColor();
    }

    @Override
    public String getName() {
        return car.getName();
    }
}
