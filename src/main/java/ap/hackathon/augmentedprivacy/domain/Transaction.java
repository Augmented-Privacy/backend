package ap.hackathon.augmentedprivacy.domain;

import lombok.Data;

@Data
public class Transaction {

    private String description;
    private String amount;
    private String destinationIban;

}
