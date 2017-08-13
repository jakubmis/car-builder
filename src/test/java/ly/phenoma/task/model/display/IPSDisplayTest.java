package ly.phenoma.task.model.display;

import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.IPS;
import static org.junit.Assert.assertEquals;

public class IPSDisplayTest {

    private IPSDisplay ipsDisplay;

    @Before
    public void setUp() throws Exception {
        ipsDisplay = new IPSDisplay(1.0f);
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(IPS, ipsDisplay.catalogName());
    }

}