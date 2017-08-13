package ly.phenoma.task.model.interior;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static ly.phenoma.task.constant.catalog.CatalogNames.AIR_CONDITIONING;
import static ly.phenoma.task.constant.catalog.CatalogNames.STANDARD_SPEAKERS;
import static org.junit.Assert.assertEquals;

public class BestInteriorTest {

    private BestInterior bestInterior;

    @Before
    public void setUp() throws Exception {
        bestInterior = new BestInterior();
    }

    @Test
    public void loadBestOffer() throws Exception {
        List<String> elements = asList(STANDARD_SPEAKERS, AIR_CONDITIONING);
        bestInterior.loadBestOffer(elements);
        assertEquals(elements, bestInterior.getElements());
    }

}