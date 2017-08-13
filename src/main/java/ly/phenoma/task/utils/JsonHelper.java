package ly.phenoma.task.utils;

import org.json.JSONObject;

/**
 * JsonHelper class is responsible for getting field from JSONObject when it is available
 */
public class JsonHelper {

    public static String getField(JSONObject jsonCar, String field) {
        String result = null;
        if (jsonCar.has(field)) {
            result = jsonCar.getString(field);
        }
        return result;
    }
}
