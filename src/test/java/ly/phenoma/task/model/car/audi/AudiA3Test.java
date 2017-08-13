package ly.phenoma.task.model.car.audi;

import ly.phenoma.task.model.car.BasicCar;
import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.AUDI_A3_BASE;
import static org.junit.Assert.assertEquals;

public class AudiA3Test {

    private AudiA3 audiA3;

    @Before
    public void setUp() throws Exception {
        audiA3 = new AudiA3(BasicCar.builder().build());
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(AUDI_A3_BASE, audiA3.catalogName());
    }

    @Test
    public void numberOfDoors() throws Exception {
        assertEquals(3, audiA3.numberOfDoors());
    }

}