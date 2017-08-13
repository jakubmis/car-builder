package ly.phenoma.task.factory;

import ly.phenoma.task.model.display.Display;
import ly.phenoma.task.model.display.IPSDisplay;
import ly.phenoma.task.model.display.TFTDisplay;
import ly.phenoma.task.model.display.TNDisplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static ly.phenoma.task.constant.input.JsonFields.*;

/**
 * DisplayFactory is simple factory for construction of all Display implementations. Given text should be in format:
 * "IPS 5.2", where first part is name and second float grade.
 */
@Component
class DisplayFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayFactory.class);
    private static final String SEPARATOR = " ";

    private final BeanFactory factory;

    @Autowired
    public DisplayFactory(BeanFactory factory) {
        this.factory = factory;
    }

    public Display get(String text) {
        String[] split = text.split(SEPARATOR);
        if (split.length == 2) {
            String name = split[0];
            Float value = validate(getDisplayValue(split[1]));
            if (value != null) {
                switch (name) {
                    case IPS:
                        return factory.getBean(IPSDisplay.class, value);
                    case TFT:
                        return factory.getBean(TFTDisplay.class, value);
                    case TN:
                        return factory.getBean(TNDisplay.class, value);
                }
            }
        }
        return null;
    }

    private Float validate(Float displayValue) {
        if (displayValue != null && displayValue > 2.99 && displayValue < 7.01) {
            return displayValue;
        } else {
            LOGGER.error("Display has wrong value!");
            return null;
        }
    }

    private Float getDisplayValue(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            LOGGER.error("Error while parsing value of display");
            return null;
        }
    }
}
