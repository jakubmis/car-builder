package ly.phenoma.task.factory;

import ly.phenoma.task.model.car.BasicCar;
import ly.phenoma.task.model.car.Car;
import ly.phenoma.task.model.car.audi.AudiA3;
import ly.phenoma.task.model.car.audi.AudiA4;
import ly.phenoma.task.model.car.audi.AudiA6;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static ly.phenoma.task.constant.input.JsonFields.*;


/**
 * AudiFactory is simple factory for construction of all Audi implementations
 */
@Component
public class AudiFactory {

    private final BeanFactory factory;

    @Autowired
    public AudiFactory(BeanFactory factory) {
        this.factory = factory;
    }

    public Optional<Car> get(String name, BasicCar car) {
        switch (name) {
            case AUDI_A3:
                return Optional.of(factory.getBean(AudiA3.class, car));
            case AUDI_A4:
                return Optional.of(factory.getBean(AudiA4.class, car));
            case AUDI_A6:
                return Optional.of(factory.getBean(AudiA6.class, car));
        }
        return Optional.empty();
    }
}
