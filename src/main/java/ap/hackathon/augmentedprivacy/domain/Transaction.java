package ap.hackathon.augmentedprivacy.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {

    private String description;
    private String amount;
    private Date transactionDate;
    private MutationType mutationType;

    private String fromIban;
    private String destinationIban;

}
