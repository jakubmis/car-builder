package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Wheel18Test {

    private Wheel18 wheel18;

    @Before
    public void setUp() throws Exception {
        wheel18 = new Wheel18();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.RIMS_18, wheel18.catalogName());
    }

}