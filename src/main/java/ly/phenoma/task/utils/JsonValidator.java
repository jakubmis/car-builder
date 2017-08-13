package ly.phenoma.task.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static ly.phenoma.task.constant.input.JsonFields.*;
import static org.junit.Assert.assertTrue;

/**
 * Basic input validator for checking content of loaded file. It has to be in json format and it should have
 * required fields as: RIMS, TRANSMISSION, ENGINE, INTERIOR. Also Engine object should have right format.
 */
public class JsonValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonValidator.class);

    public static boolean isValid(String text) {
        try {
            JSONObject jsonCar = new JSONObject(text);
            checkNotEmpty(jsonCar);
            checkRequiredElements(jsonCar);
            return true;
        } catch (JSONException e) {
            LOGGER.error("Input json has wrong content");
        } catch (AssertionError e) {
            LOGGER.error(e.getMessage());
        }
        return false;
    }

    private static void checkRequiredElements(JSONObject jsonCar) {
        JSONObject jsonComponents = jsonCar.getJSONObject(jsonCar.keys().next());
        Stream.of(RIMS, TRANSMISSION, ENGINE, INTERIOR)
                .forEach(element -> assertTrue("Json does not have required field: " + element, jsonComponents.has(element)));
        checkEngine(jsonComponents);
    }

    private static void checkEngine(JSONObject jsonComponents) {
        JSONObject engine = jsonComponents.getJSONObject(ENGINE);
        Stream.of(ENGINE_TYPE, ENGINE_PARAMS)
                .forEach(element -> assertTrue("Json does not have required field: " + element, engine.has(element)));
        checkEngineParams(engine);
    }

    private static void checkEngineParams(JSONObject engine) {
        JSONObject engineParams = engine.getJSONObject(ENGINE_PARAMS);
        Stream.of(ENGINE_HORSEPOWER, ENGINE_CAPACITY)
                .forEach(element -> assertTrue("Json does not have required field: " + element, engineParams.has(element)));
    }

    private static void checkNotEmpty(JSONObject jsonCar) {
        assertTrue("Empty json file", jsonCar.keys().hasNext());
    }
}
