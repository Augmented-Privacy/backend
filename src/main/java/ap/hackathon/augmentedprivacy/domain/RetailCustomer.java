package ap.hackathon.augmentedprivacy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class RetailCustomer {

    private String name;
    private Account debitAccount;
    private Product mortgage;
    private List<Transaction> transactions;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(",");



        transactions.forEach(transaction -> {



            stringBuilder.append(transaction.toString());
        });
        return stringBuilder.toString();
    }

}
