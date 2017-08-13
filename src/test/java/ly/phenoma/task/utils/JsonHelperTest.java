package ly.phenoma.task.utils;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JsonHelperTest {

    @Test
    public void getField() throws Exception {
        String json = "{ \"Field\" : \"value\"}";
        String field = JsonHelper.getField(new JSONObject(json), "Field");
        assertEquals(field, "value");
    }

    @Test
    public void getFieldWhichNotExist() throws Exception {
        String json = "{ \"Field\" : \"value\"}";
        String field = JsonHelper.getField(new JSONObject(json), "abc");
        assertNull(field);
    }
}