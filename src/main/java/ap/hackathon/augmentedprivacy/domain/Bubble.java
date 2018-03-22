package ap.hackathon.augmentedprivacy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Bubble {
    
    private int bubble;
    @JsonProperty("spending")
    private Map<String, BigDecimal> bucket;
    private Map<String, Integer> importance;

}
