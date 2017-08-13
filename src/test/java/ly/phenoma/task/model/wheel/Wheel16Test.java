package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Wheel16Test {

    private Wheel16 wheel16;

    @Before
    public void setUp() throws Exception {
        wheel16 = new Wheel16();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.RIMS_16, wheel16.catalogName());
    }

}