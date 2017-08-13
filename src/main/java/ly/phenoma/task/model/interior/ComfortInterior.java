package ly.phenoma.task.model.interior;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ly.phenoma.task.constant.catalog.CatalogNames.*;
import static ly.phenoma.task.constant.input.JsonFields.INTERIOR;

@Component(value = INTERIOR + "comfort")
public class ComfortInterior extends Interior {

    public ComfortInterior() {
        getElements()
                .addAll(Stream.of(AUTOMATIC_AIR_CONDITIONING, LEATHER_UPHOLSTERY, LEATHER_UPHOLSTERY, STANDARD_SPEAKERS)
                        .collect(Collectors.toList()));
    }
}
