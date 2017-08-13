package ly.phenoma.task.configurator;

import ly.phenoma.task.AppConf;
import ly.phenoma.task.model.car.Car;
import ly.phenoma.task.model.car.audi.AudiA3;
import ly.phenoma.task.model.car.audi.AudiA4;
import ly.phenoma.task.model.car.audi.AudiA6;
import ly.phenoma.task.model.display.IPSDisplay;
import ly.phenoma.task.model.engine.DieselEngine;
import ly.phenoma.task.model.engine.PetrolEngine;
import ly.phenoma.task.model.interior.BestInterior;
import ly.phenoma.task.model.interior.ComfortInterior;
import ly.phenoma.task.model.interior.SportInterior;
import ly.phenoma.task.model.transmission.AutomaticTransmission;
import ly.phenoma.task.model.transmission.ManualTransmission;
import ly.phenoma.task.model.wheel.Wheel15;
import ly.phenoma.task.model.wheel.Wheel17;
import ly.phenoma.task.model.wheel.Wheel19;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConf.class)
public class AudiConfiguratorTest {

    @Autowired
    private AudiConfigurator audiConfigurator;
    private String json;

    @Test
    public void buildA3() throws Exception {
        json = loadCorrectJson("a3.json");
        Optional<Car> optionalCar = audiConfigurator.configure(json);

        assertTrue(optionalCar.isPresent());
        Car car = optionalCar.get();
        assertNotNullElements(car);
        assertEquals(119.9, car.price(), 0.1);
        assertTrue(car instanceof AudiA3);
        assertEquals("A3 Saloon", car.getName());
        assertEquals("red", car.getColor().getValue());
        assertEquals("141", car.getEngine().getEngineParams().getEngineHorsepower().getValue());
        assertEquals("16", car.getEngine().getEngineParams().getEngineCapacity().getValue());
        assertTrue(car.getEngine() instanceof PetrolEngine);
        assertTrue(car.getInterior() instanceof ComfortInterior);
        assertTrue(car.getTransmission() instanceof AutomaticTransmission);
        assertTrue(car.getWheel() instanceof Wheel15);
    }

    @Test
    public void buildA4() throws Exception {
        json = loadCorrectJson("a4.json");
        Optional<Car> optionalCar = audiConfigurator.configure(json);

        assertTrue(optionalCar.isPresent());
        Car car = optionalCar.get();
        assertNotNullElements(car);
        assertEquals(128.3, car.price(), 0.1);
        assertTrue(car instanceof AudiA4);
        assertEquals("A4 Black Edition", car.getName());
        assertEquals("black", car.getColor().getValue());
        assertEquals("161", car.getEngine().getEngineParams().getEngineHorsepower().getValue());
        assertEquals("18", car.getEngine().getEngineParams().getEngineCapacity().getValue());
        assertTrue(car.getDisplay().isPresent());
        assertEquals(5.2f, car.getDisplay().get().getValue(), 0.1);
        assertTrue(car.getDisplay().get() instanceof IPSDisplay);
        assertTrue(car.getEngine() instanceof DieselEngine);
        assertTrue(car.getInterior() instanceof SportInterior);
        assertTrue(car.getTransmission() instanceof ManualTransmission);
        assertTrue(car.getWheel() instanceof Wheel19);
    }

    @Test
    public void buildA6() throws Exception {
        json = loadCorrectJson("a6.json");
        Optional<Car> optionalCar = audiConfigurator.configure(json);

        assertTrue(optionalCar.isPresent());
        Car car = optionalCar.get();
        assertNotNullElements(car);
        assertEquals(172.3, car.price(), 0.1);
        assertTrue(car instanceof AudiA6);
        assertEquals("A6 Avant", car.getName());
        assertEquals("silver", car.getColor().getValue());
        assertEquals("178", car.getEngine().getEngineParams().getEngineHorsepower().getValue());
        assertEquals("20", car.getEngine().getEngineParams().getEngineCapacity().getValue());
        assertTrue(car.getEngine() instanceof PetrolEngine);
        assertTrue(car.getInterior() instanceof BestInterior);
        assertTrue(car.getTransmission() instanceof AutomaticTransmission);
        assertTrue(car.getWheel() instanceof Wheel17);

        List<String> elements = car.getInterior().getElements();
        elements.forEach(System.out::print);
    }

    private void assertNotNullElements(Car car) {
        assertNotNull(car.getTransmission());
        assertNotNull(car.getColor());
        assertNotNull(car.getWheel());
        assertNotNull(car.getInterior());
        assertNotNull(car.getEngine());
        assertNotNull(car.getEngine().getEngineParams());
        assertNotNull(car.getEngine().getEngineParams().getEngineHorsepower());
        assertNotNull(car.getEngine().getEngineParams().getEngineCapacity());
    }

    private String loadCorrectJson(String jsonPath) throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource(jsonPath).toURI());
        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}