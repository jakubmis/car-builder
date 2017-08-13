package ly.phenoma.task.configurator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SatisfactionCatalogTest {


    @Mock
    private PriceCatalog priceCatalog;
    @Mock
    private BestOfferGenerator bestOfferGenerator;
    private SatisfactionCatalog satisfactionCatalog;

    @Before
    public void setUp() throws Exception {
        satisfactionCatalog = new SatisfactionCatalog(priceCatalog, bestOfferGenerator);
    }

    @Test
    public void load() throws Exception {
        when(priceCatalog.containsAll(any())).thenReturn(true);
        when(bestOfferGenerator.generateBestOffer(any())).thenReturn(true);
        boolean load = satisfactionCatalog.load("satisfactionCatalog.csv");
        assertTrue(load);
    }

    @Test
    public void loadPriceCatalogFailure() throws Exception {
        when(priceCatalog.containsAll(any())).thenReturn(false);
        when(bestOfferGenerator.generateBestOffer(any())).thenReturn(true);
        boolean load = satisfactionCatalog.load("satisfactionCatalog.csv");
        assertFalse(load);
    }

    @Test
    public void loadBestOfferGeneratorFailure() throws Exception {
        when(priceCatalog.containsAll(any())).thenReturn(false);
        when(bestOfferGenerator.generateBestOffer(any())).thenReturn(true);
        boolean load = satisfactionCatalog.load("satisfactionCatalog.csv");
        assertFalse(load);
    }

}