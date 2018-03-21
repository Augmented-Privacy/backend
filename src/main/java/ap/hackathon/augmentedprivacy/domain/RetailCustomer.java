package ap.hackathon.augmentedprivacy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetailCustomer {

    private String name;
    private Account debitAccount;
    private Product mortgage;

}
