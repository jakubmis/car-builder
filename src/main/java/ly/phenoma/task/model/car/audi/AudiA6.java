package ly.phenoma.task.model.car.audi;

import ly.phenoma.task.model.car.BasicCar;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.catalog.CatalogNames.AUDI_A6_BASE;

@Component
@Scope(value = "prototype")
public class AudiA6 extends Audi {

    public AudiA6(BasicCar car) {
        super(car);
    }

    @Override
    public String catalogName() {
        return AUDI_A6_BASE;
    }

    @Override
    public int numberOfDoors() {
        return 4;
    }

}
