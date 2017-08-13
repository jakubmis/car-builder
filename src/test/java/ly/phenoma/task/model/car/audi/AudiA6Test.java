package ly.phenoma.task.model.car.audi;

import ly.phenoma.task.model.car.BasicCar;
import org.junit.Before;
import org.junit.Test;

import static ly.phenoma.task.constant.catalog.CatalogNames.AUDI_A6_BASE;
import static org.junit.Assert.assertEquals;

public class AudiA6Test {

    private AudiA6 audiA6;

    @Before
    public void setUp() throws Exception {
        audiA6 = new AudiA6(BasicCar.builder().build());
    }

    @Test
    public void catalogName() throws Exception {
        assertEquals(AUDI_A6_BASE, audiA6.catalogName());
    }

    @Test
    public void numberOfDoors() throws Exception {
        assertEquals(4, audiA6.numberOfDoors());
    }

}