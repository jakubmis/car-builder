package ly.phenoma.task.factory;

import ly.phenoma.task.model.car.BasicCar;
import ly.phenoma.task.model.car.Car;
import ly.phenoma.task.model.car.audi.AudiA3;
import ly.phenoma.task.model.car.audi.AudiA4;
import ly.phenoma.task.model.car.audi.AudiA6;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;

import java.util.Optional;

import static ly.phenoma.task.constant.input.JsonFields.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class AudiFactoryTest {

    @Mock
    private BeanFactory beanFactory;
    private AudiFactory audiFactory;
    private BasicCar basicCar;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        audiFactory = new AudiFactory(beanFactory);
        basicCar = BasicCar.builder().build();
    }

    @Test
    public void getAudiA3() throws Exception {
        when(beanFactory.getBean(eq(AudiA3.class), eq(basicCar))).thenReturn(new AudiA3(basicCar));
        Optional<Car> car = audiFactory.get(AUDI_A3, basicCar);
        assertTrue(car.isPresent());
        assertTrue(car.get() instanceof AudiA3);
    }

    @Test
    public void getAudiA4() throws Exception {
        when(beanFactory.getBean(eq(AudiA4.class), eq(basicCar))).thenReturn(new AudiA4(basicCar));
        Optional<Car> car = audiFactory.get(AUDI_A4, basicCar);
        assertTrue(car.isPresent());
        assertTrue(car.get() instanceof AudiA4);
    }

    @Test
    public void getAudiA6() throws Exception {
        when(beanFactory.getBean(eq(AudiA6.class), eq(basicCar))).thenReturn(new AudiA6(basicCar));
        Optional<Car> car = audiFactory.get(AUDI_A6, basicCar);
        assertTrue(car.isPresent());
        assertTrue(car.get() instanceof AudiA6);
    }

    @Test
    public void getUndefinedCar() throws Exception {
        Optional<Car> car = audiFactory.get("Mazda", BasicCar.builder().build());
        assertFalse(car.isPresent());
    }

}