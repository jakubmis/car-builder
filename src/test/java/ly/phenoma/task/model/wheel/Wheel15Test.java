package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Wheel15Test {

    private Wheel15 wheel15;

    @Before
    public void setUp() throws Exception {
        wheel15 = new Wheel15();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.RIMS_15, wheel15.catalogName());
    }
}