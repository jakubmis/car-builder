package ly.phenoma.task.factory;

import ly.phenoma.task.configurator.PriceCatalog;
import ly.phenoma.task.model.engine.DieselEngine;
import ly.phenoma.task.model.engine.Engine;
import ly.phenoma.task.model.engine.PetrolEngine;
import ly.phenoma.task.model.engine.parameters.EngineCapacity;
import ly.phenoma.task.model.engine.parameters.EngineHorsepower;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class EngineFactoryTest {

    private static final String PETROL_ENGINE = "{\"engine_params\":{\"engine_horsepower\":141,\"engine_capacity\":1.6}," +
            "\"type\":\"petrol\"}";
    private static final String DIESEL_ENGINE = "{\"engine_params\":{\"engine_horsepower\":141,\"engine_capacity\":1.6}," +
            "\"type\":\"diesel\"}";
    private static final String UNDEFINED_ENGINE = "{\"engine_params\":{\"engine_horsepower\":141,\"engine_capacity\":1.6}," +
            "\"type\":\"undefined\"}";

    private EngineFactory engineFactory;

    @Mock
    private BeanFactory beanFactory;

    @Mock
    private PriceCatalog priceCatalog;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        engineFactory = new EngineFactory(beanFactory, priceCatalog);
    }

    @Test
    public void getDiesel() throws Exception {
        when(beanFactory.getBean(eq(DieselEngine.class), any(EngineParams.class))).thenReturn(new DieselEngine(engine()));
        when(priceCatalog.contains(any())).thenReturn(true);
        Engine engine = engineFactory.get(new JSONObject(DIESEL_ENGINE));
        assertNotNull(engine);
        assertTrue(engine instanceof DieselEngine);
    }

    @Test
    public void getPetrol() throws Exception {
        when(beanFactory.getBean(eq(PetrolEngine.class), any(EngineParams.class))).thenReturn(new PetrolEngine(engine()));
        when(priceCatalog.contains(any())).thenReturn(true);
        Engine engine = engineFactory.get(new JSONObject(PETROL_ENGINE));
        assertNotNull(engine);
        assertTrue(engine instanceof PetrolEngine);
    }

    @Test
    public void getUndefinedEngine() throws Exception {
        Engine engine = engineFactory.get(new JSONObject(UNDEFINED_ENGINE));
        assertNull(engine);
    }

    @Test
    public void getNotCorrectEngine() throws Exception {
        when(beanFactory.getBean(eq(PetrolEngine.class), any(EngineParams.class))).thenReturn(new PetrolEngine(engine()));
        when(priceCatalog.contains(any())).thenReturn(false);
        Engine engine = engineFactory.get(new JSONObject(PETROL_ENGINE));
        assertNull(engine);
    }

    private EngineParams engine() {
        return new EngineParams(new EngineHorsepower("141"), new EngineCapacity("1.6"));
    }

}