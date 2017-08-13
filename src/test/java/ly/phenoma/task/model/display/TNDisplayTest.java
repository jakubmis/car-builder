package ly.phenoma.task.model.display;

import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.TN;
import static org.junit.Assert.assertEquals;

public class TNDisplayTest {

    private TNDisplay tnDisplay;

    @Before
    public void setUp() throws Exception {
        tnDisplay = new TNDisplay(1.0f);
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(TN, tnDisplay.catalogName());
    }

}