package ly.phenoma.task.configurator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PriceCatalogTest {

    private PriceCatalog priceCatalog;

    @Before
    public void setUp() throws Exception {
        priceCatalog = new PriceCatalog();
    }

    @Test
    public void load() throws Exception {
        boolean loaded = priceCatalog.load("pricingCatalog.csv");
        assertTrue(loaded);
        assertFalse(priceCatalog.getPrices().isEmpty());
    }

    @Test
    public void loadWrongData() throws Exception {
        boolean loaded = priceCatalog.load("pricingCatalogException.csv");
        assertFalse(loaded);
        assertTrue(priceCatalog.getPrices().isEmpty());
    }

    @Test
    public void getPricesEmptyList() throws Exception {
        assertTrue(priceCatalog.getPrices().isEmpty());
    }

}