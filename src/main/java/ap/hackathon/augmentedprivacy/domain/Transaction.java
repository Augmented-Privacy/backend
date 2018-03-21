package ap.hackathon.augmentedprivacy.domain;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Transaction {

    private String description;
    private BigInteger amount;
    private Date transactionDate;
    private MutationType mutationType;

}
