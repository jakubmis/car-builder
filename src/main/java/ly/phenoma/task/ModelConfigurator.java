package ly.phenoma.task;

import ly.phenoma.task.configurator.AudiConfigurator;
import ly.phenoma.task.model.car.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;
import java.util.Scanner;

/**
 * Main application class, which reads input json and try to parse it. Positive case of operation should give
 * built Car object and print it's price.
 */
@SpringBootApplication
public class ModelConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelConfigurator.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ModelConfigurator.class).web(false).run(args);

        LOGGER.info("Pass in a one-line input json:");
        Scanner scanner = new Scanner(System.in);
        String json = scanner.nextLine();

        AudiConfigurator audiConfigurator = applicationContext.getBean(AudiConfigurator.class);
        Optional<Car> build = audiConfigurator.configure(json);
        build.ifPresent(car -> LOGGER.info("Audi price : {}", String.valueOf(car.price())));
    }

}
