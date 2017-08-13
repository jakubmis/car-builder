package ly.phenoma.task.configurator;

import ly.phenoma.task.model.interior.BestInterior;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static ly.phenoma.task.constant.catalog.CatalogNames.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BestOfferGeneratorTest {

    @Mock
    private BestInterior bestInterior;
    private BestOfferGenerator bestOfferGenerator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(bestInterior);
        bestOfferGenerator = new BestOfferGenerator(bestInterior);
    }

    @Test
    public void generateBestOffer() throws Exception {
        Map<String, Float> map = new HashMap<String, Float>() {{
            put(STANDARD_SPEAKERS, 1f);
            put(SPEAKERS_WITH_SUBWOOFER, 2f);
            put(LEATHER_UPHOLSTERY, 1f);
            put(ALCANTRA_UPHOLSTERY, 2f);
            put(AUTOMATIC_AIR_CONDITIONING, 2f);
            put(PLASTIC_FINISH, 2f);
            put(MANUAL_AIR_CONDITIONING, 1f);
        }};
        boolean result = bestOfferGenerator.generateBestOffer(map);
        assertTrue(result);
        verify(bestInterior, times(1)).loadBestOffer(any());
    }

    @Test
    public void generateBestOfferNotEnoughElements() throws Exception {
        Map<String, Float> map = new HashMap<String, Float>() {{
            put(STANDARD_SPEAKERS, 1f);
            put(SPEAKERS_WITH_SUBWOOFER, 2f);
            put(LEATHER_UPHOLSTERY, 1f);
            put(ALCANTRA_UPHOLSTERY, 2f);
            put(AUTOMATIC_AIR_CONDITIONING, 2f);
            put(MANUAL_AIR_CONDITIONING, 1f);
        }};
        boolean result = bestOfferGenerator.generateBestOffer(map);
        assertFalse(result);
        verify(bestInterior, times(0)).loadBestOffer(any());
    }

}