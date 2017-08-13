package ly.phenoma.task.utils;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JsonValidatorTest {

    @Test
    public void isValid() throws Exception {
        String correctJson = loadCorrectJson();
        boolean valid = JsonValidator.isValid(correctJson);
        assertTrue(valid);
    }

    @Test
    public void isValidWithEmptyFile() throws Exception {
        String correctJson = "{\"A3\": {}}";
        boolean valid = JsonValidator.isValid(correctJson);
        assertFalse(valid);
    }

    private String loadCorrectJson() throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("a3.json").toURI());
        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}