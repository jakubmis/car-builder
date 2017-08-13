package ly.phenoma.task.configurator;

import ly.phenoma.task.factory.ItemFactory;
import ly.phenoma.task.model.base.Item;
import ly.phenoma.task.model.engine.PetrolEngine;
import ly.phenoma.task.model.engine.parameters.EngineCapacity;
import ly.phenoma.task.model.engine.parameters.EngineHorsepower;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import ly.phenoma.task.model.interior.ComfortInterior;
import ly.phenoma.task.model.transmission.AutomaticTransmission;
import ly.phenoma.task.model.wheel.Wheel15;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ItemConfiguratorTest {

    private ItemConfigurator itemConfigurator;

    @Mock
    private ItemFactory itemFactory;

    private static final String ENGINE_PARAMS = "{\"engine_params\":{\"engine_horsepower\":141,\"engine_capacity\":1.6}," +
            "\"type\":\"petrol\"}";
    private static final String VALID_CAR_COMPONENTS = "{ \"name\": \"A3 Saloon\", \"engine\": " + ENGINE_PARAMS +
            ", \"color\": \"red\", \"transmission\": \"automatic\", \"rim_size\": 15, \"interior\": \"comfort\" }";


    @Before
    public void setUp() throws Exception {
        initMocks(this);
        itemConfigurator = new ItemConfigurator(itemFactory);
    }

    @Test
    public void getCarComponents() throws Exception {
        when(itemFactory.get(eq("rim_size"), eq("15"))).thenReturn(Optional.of(new Wheel15()));
        when(itemFactory.get(eq("interior"), eq("comfort"))).thenReturn(Optional.of(new ComfortInterior()));
        when(itemFactory.get(eq("transmission"), eq("automatic"))).thenReturn(Optional.of(new AutomaticTransmission()));
        when(itemFactory.get(eq("engine"), eq(ENGINE_PARAMS))).thenReturn(Optional.of(engine()));
        List<Item> carComponents = itemConfigurator.getCarComponents(new JSONObject(VALID_CAR_COMPONENTS));
        assertFalse(carComponents.isEmpty());
        assertEquals(4, carComponents.size());
    }

    private Item engine() {
        return new PetrolEngine(new EngineParams(new EngineHorsepower("1"), new EngineCapacity("2")));
    }

}