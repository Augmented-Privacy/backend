package ap.hackathon.augmentedprivacy.domain.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Bubble {

    private Map<String, Double> importance;

}
