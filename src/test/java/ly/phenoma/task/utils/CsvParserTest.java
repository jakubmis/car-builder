package ly.phenoma.task.utils;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CsvParserTest {

    @Test
    public void load() throws Exception {
        Map<String, Float> load = CsvParser.load("pricingCatalog.csv");
        assertNotNull(load);
        assertFalse(load.isEmpty());
    }

}