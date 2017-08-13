package ly.phenoma.task.model.wheel;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Wheel19Test {

    private Wheel19 wheel19;

    @Before
    public void setUp() throws Exception {
        wheel19 = new Wheel19();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.RIMS_19, wheel19.catalogName());
    }

}