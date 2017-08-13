package ly.phenoma.task.model.interior;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ly.phenoma.task.constant.catalog.CatalogNames.*;
import static ly.phenoma.task.constant.input.JsonFields.INTERIOR;

@Component(value = INTERIOR + "sport")
public class SportInterior extends Interior {

    public SportInterior() {
        getElements()
                .addAll(Stream.of(PLASTIC_FINISH, MANUAL_AIR_CONDITIONING, SPEAKERS_WITH_SUBWOOFER, ALCANTRA_UPHOLSTERY)
                        .collect(Collectors.toList()));
    }
}
