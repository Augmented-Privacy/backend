package ap.hackathon.augmentedprivacy.domain.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Customer {
    
    private int bubbleId;
    private Bubble bubble;
    @JsonProperty("spending")
    private Map<String, BigDecimal> bucket;

}
