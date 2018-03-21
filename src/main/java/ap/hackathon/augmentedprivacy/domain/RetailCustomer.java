package ap.hackathon.augmentedprivacy.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetailCustomer {

    private String name;
    private Account debitAccount;
    private Product mortgage;

}
