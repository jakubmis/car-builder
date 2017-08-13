package ly.phenoma.task.configurator;

import ly.phenoma.task.model.interior.BestInterior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static ly.phenoma.task.constant.catalog.CatalogNames.*;

/**
 * BestOfferGenerator class is responsible for generating best offer algorithm which calculates most
 * satisfied elements which are required to build Interior. It also loads generated offer to BestInterior class.
 */
@Component
class BestOfferGenerator {

    private final BestInterior bestInterior;

    @Autowired
    public BestOfferGenerator(BestInterior bestInterior) {
        this.bestInterior = bestInterior;
    }

    public boolean generateBestOffer(Map<String, Float> satisfactions) {
        List<String> requiredElements = asList(SPEAKERS, FINISH, AIR_CONDITIONING, UPHOLSTERY);
        List<String> collect = requiredElements
                .stream()
                .map(requiredElement -> getMostSatisfied(satisfactions, requiredElement))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        boolean loadedCorrectly = collect.size() == requiredElements.size();
        if (loadedCorrectly) {
            bestInterior.loadBestOffer(collect);
        }
        return loadedCorrectly;
    }

    private Optional<String> getMostSatisfied(Map<String, Float> satisfactions, String element) {
        return satisfactions
                .entrySet()
                .stream()
                .filter(el -> el.getKey().contains(element))
                .sorted((o1, o2) -> Float.compare(o2.getValue(), o1.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
