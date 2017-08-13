package ly.phenoma.task.model.transmission;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutomaticTransmissionTest {

    private AutomaticTransmission automaticTransmission;

    @Before
    public void setUp() throws Exception {
        automaticTransmission = new AutomaticTransmission();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.AUTOMATIC_TRANSMISSION, automaticTransmission.catalogName());
    }

}