package ly.phenoma.task.model.transmission;

import ly.phenoma.task.constant.catalog.CatalogNames;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManualTransmissionTest {

    private ManualTransmission manualTransmission;

    @Before
    public void setUp() throws Exception {
        manualTransmission = new ManualTransmission();
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(CatalogNames.MANUAL_TRANSMISSION, manualTransmission.catalogName());
    }

}