package ly.phenoma.task.model.interior;

import org.springframework.stereotype.Component;

import java.util.List;

import static ly.phenoma.task.constant.input.JsonFields.INTERIOR;

@Component(value = INTERIOR + "best offer")
public class BestInterior extends Interior {

    public void loadBestOffer(List<String> bestOffer) {
        getElements()
                .addAll(bestOffer);
    }
}
