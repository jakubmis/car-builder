package ly.phenoma.task.model.car.audi;

import ly.phenoma.task.model.car.BasicCar;
import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.AUDI_A4_BASE;
import static org.junit.Assert.assertEquals;

public class AudiA4Test {

    private AudiA4 audiA4;

    @Before
    public void setUp() throws Exception {
        audiA4 = new AudiA4(BasicCar.builder().build());
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(AUDI_A4_BASE, audiA4.catalogName());
    }

    @Test
    public void numberOfDoors() throws Exception {
        assertEquals(4, audiA4.numberOfDoors());
    }

}