package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Wheel17Test {

    private Wheel17 wheel17;

    @Before
    public void setUp() throws Exception {
        wheel17 = new Wheel17();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.RIMS_17, wheel17.catalogName());
    }

}