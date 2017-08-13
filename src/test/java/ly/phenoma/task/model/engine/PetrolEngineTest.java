package ly.phenoma.task.model.engine;

import ly.phenoma.task.model.engine.parameters.EngineCapacity;
import ly.phenoma.task.model.engine.parameters.EngineHorsepower;
import ly.phenoma.task.model.engine.parameters.EngineParams;
import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.PETROL;
import static org.junit.Assert.assertEquals;

public class PetrolEngineTest {

    private PetrolEngine petrolEngine;

    @Before
    public void setUp() throws Exception {
        petrolEngine = new PetrolEngine(new EngineParams(new EngineHorsepower("122"), new EngineCapacity("1.7")));
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(PETROL + "_17_122", petrolEngine.catalogName());
    }

}