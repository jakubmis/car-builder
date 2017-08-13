package ly.phenoma.task.model.engine;

import ly.phenoma.task.model.engine.parameters.EngineCapacity;
import ly.phenoma.task.model.engine.parameters.EngineHorsepower;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.DIESEL;
import static org.junit.Assert.assertEquals;

public class DieselEngineTest {

    private DieselEngine dieselEngine;

    @Before
    public void setUp() throws Exception {
        dieselEngine = new DieselEngine(new EngineParams(new EngineHorsepower("122"), new EngineCapacity("1.7")));
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(DIESEL + "_17_122", dieselEngine.catalogName());
    }

}