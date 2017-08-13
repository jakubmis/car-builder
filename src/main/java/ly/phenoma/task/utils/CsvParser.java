package ly.phenoma.task.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CSVParser class is responsible for loading csv files from resource at given URI. It tries to parse input
 * based on 2 columns format with "," separator. First header line is ignored.
 * Second column of inputted file should have float data. Positive case of load() operation should return Map
 * of String-Float.
 */
public class CsvParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvParser.class);

    public static Map<String, Float> load(String resourceName) {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource(resourceName).toURI());
            try (Stream<String> stream = Files.lines(path)) {
                return stream
                        .skip(1)
                        .map(line -> line.split(","))
                        .filter(element -> element.length == 2)
                        .collect(Collectors.toMap(element -> element[0], element -> Float.parseFloat(element[1])));
            } catch (IOException e) {
                LOGGER.error("Can't find file " + resourceName, e);
            }
        } catch (Exception e) {
            LOGGER.error("Fatal error while parsing file " + resourceName, e);
        }
        return new HashMap<>();
    }
}
