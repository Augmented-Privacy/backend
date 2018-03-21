package ap.hackathon.augmentedprivacy.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Account {

    private BigDecimal balance;
    private List<Transaction> transactions;

}
