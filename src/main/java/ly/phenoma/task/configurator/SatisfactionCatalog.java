package ly.phenoma.task.configurator;

import ly.phenoma.task.utils.CsvParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SatisfactionCatalog class is responsible for holding satisfaction grade from resource file. It also
 * invokes BestOfferGenerator algorithm.
 */
@Component
class SatisfactionCatalog {

    private static final Logger LOGGER = LoggerFactory.getLogger(SatisfactionCatalog.class);
    private final PriceCatalog priceCatalog;
    private final BestOfferGenerator generator;

    @Autowired
    public SatisfactionCatalog(PriceCatalog priceCatalog, BestOfferGenerator generator) {
        this.priceCatalog = priceCatalog;
        this.generator = generator;
    }

    public boolean load(String resourceName) {
        Map<String, Float> satisfactions = CsvParser.load(resourceName);
        boolean containsAll = priceCatalog.containsAll(satisfactions.keySet());
        if (!containsAll) {
            LOGGER.error("Price catalog does not contains all elements from satisfaction catalog!");
        }
        boolean bestOffer = generator.generateBestOffer(satisfactions);
        if (!bestOffer) {
            LOGGER.error("Best offer could not be generated!");
        }
        return !satisfactions.isEmpty() && containsAll && bestOffer;
    }
}
