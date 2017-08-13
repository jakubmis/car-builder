package ly.phenoma.task.model.engine.parameters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EngineCapacityTest {

    private EngineCapacity engineCapacity;

    @Before
    public void setUp() throws Exception {
        engineCapacity = new EngineCapacity("1.8");
    }

    @Test
    public void getValue() throws Exception {
        assertEquals("18", engineCapacity.getValue());
    }

}