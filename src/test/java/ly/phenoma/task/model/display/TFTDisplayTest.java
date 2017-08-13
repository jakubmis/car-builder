package ly.phenoma.task.model.display;

import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.TFT;
import static org.junit.Assert.assertEquals;

public class TFTDisplayTest {

    private TFTDisplay tftDisplay;

    @Before
    public void setUp() throws Exception {
        tftDisplay = new TFTDisplay(1.0f);
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(TFT, tftDisplay.catalogName());
    }

}