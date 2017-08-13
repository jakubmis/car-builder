package ly.phenoma.task.factory;

import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.display.Display;
import ly.phenoma.task.model.display.IPSDisplay;
import ly.phenoma.task.model.engine.Engine;
import ly.phenoma.task.model.engine.PetrolEngine;
import ly.phenoma.task.model.engine.parameters.EngineCapacity;
import ly.phenoma.task.model.engine.parameters.EngineHorsepower;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import ly.phenoma.task.model.interior.ComfortInterior;
import ly.phenoma.task.model.interior.Interior;
import ly.phenoma.task.model.transmission.ManualTransmission;
import ly.phenoma.task.model.transmission.Transmission;
import ly.phenoma.task.model.wheel.Wheel;
import ly.phenoma.task.model.wheel.Wheel15;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static ly.phenoma.task.constant.input.JsonFields.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ItemFactoryTest {

    private static final String ENGINE_JSON = "{\"engine_params\":{\"engine_horsepower\":141,\"engine_capacity\":1.6}," +
            "\"type\":\"diesel\"}";

    private ItemFactory itemFactory;

    @Mock
    private EngineFactory engineFactory;

    @Mock
    private DisplayFactory displayFactory;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        Map<String, Wheel> wheelMap = new HashMap<String, Wheel>() {{
            put(RIMS + 15, new Wheel15());
        }};
        Map<String, Transmission> transmissionMap = new HashMap<String, Transmission>() {{
            put(TRANSMISSION + "manual", new ManualTransmission());
        }};
        Map<String, Interior> interiorMap = new HashMap<String, Interior>() {{
            put(INTERIOR + "comfort", new ComfortInterior());
        }};
        itemFactory = new ItemFactory(wheelMap, transmissionMap, interiorMap, engineFactory, displayFactory);
    }

    @Test
    public void getRims() throws Exception {
        Optional<Item> item = itemFactory.get(RIMS, "15");
        assertTrue(item.isPresent());
    }

    @Test
    public void getRimsFailure() throws Exception {
        Optional<Item> item = itemFactory.get(RIMS, "25");
        assertFalse(item.isPresent());
    }

    @Test
    public void getTransmission() throws Exception {
        Optional<Item> item = itemFactory.get(TRANSMISSION, "manual");
        assertTrue(item.isPresent());
    }

    @Test
    public void getTransmissionFailure() throws Exception {
        Optional<Item> item = itemFactory.get(TRANSMISSION, "magic");
        assertFalse(item.isPresent());
    }

    @Test
    public void getInterior() throws Exception {
        Optional<Item> item = itemFactory.get(INTERIOR, "comfort");
        assertTrue(item.isPresent());
    }

    @Test
    public void getInteriorFailure() throws Exception {
        Optional<Item> item = itemFactory.get(INTERIOR, "ultra");
        assertFalse(item.isPresent());
    }

    @Test
    public void getUndefinedItem() throws Exception {
        Optional<Item> item = itemFactory.get("undefined", "ultra");
        assertFalse(item.isPresent());
    }

    @Test
    public void getEngine() throws Exception {
        when(engineFactory.get(any())).thenReturn(engine());
        Optional<Item> item = itemFactory.get(ENGINE, ENGINE_JSON);
        assertTrue(item.isPresent());
    }

    @Test
    public void getDisplay() throws Exception {
        when(displayFactory.get(any())).thenReturn(display());
        Optional<Item> item = itemFactory.get(LCD, TFT);
        assertTrue(item.isPresent());
    }

    private Engine engine() {
        return new PetrolEngine(new EngineParams(new EngineHorsepower("1"), new EngineCapacity("2")));
    }

    private Display display() {
        return new IPSDisplay(1.0f);
    }

}