package ap.hackathon.augmentedprivacy.domain;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Account {

    private BigInteger balance;
    private List<Transaction> transactions;

}
