package ly.phenoma.task.model.base;

import ly.phenoma.task.configurator.PriceCatalog;

import java.util.Optional;

/**
 * Item interface presents all basic operation which every Item should have.
 */
public interface Item {

    String catalogName();

    PriceCatalog getPriceCatalog();

    default float price() {
        return Optional.ofNullable(
                getPriceCatalog()
                        .getPrices()
                        .get(catalogName()))
                .orElse(0f);
    }


}
