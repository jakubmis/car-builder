package ly.phenoma.task.model.engine.parameters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EngineCapacity {

    private String value;

    public String getValue() {
        return value.replaceAll("\\.", "");
    }
}
