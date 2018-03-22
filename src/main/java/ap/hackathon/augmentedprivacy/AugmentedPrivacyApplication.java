package ap.hackathon.augmentedprivacy;

import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.domain.presentation.Bubble;
import ap.hackathon.augmentedprivacy.domain.presentation.Customer;
import ap.hackathon.augmentedprivacy.generator.TransactionGenerator;
import ap.hackathon.augmentedprivacy.helper.CustomerHelper;
import ap.hackathon.augmentedprivacy.helper.NameHelper;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AugmentedPrivacyApplication {

    private static TransactionGenerator transactionGenerator = new TransactionGenerator();

    @Getter
    private static Map<String, RetailCustomer> retailCustomers = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(AugmentedPrivacyApplication.class, args);
        List<String> names = NameHelper.getNames();
        // Generate retailCustomers
        for (String name : names  ) {
            RetailCustomer retailCustomer = new RetailCustomer();
            retailCustomer.setName(name);
            retailCustomer.setTransactions(transactionGenerator.generate100Transactions());
            retailCustomers.put(retailCustomer.getName(), retailCustomer);
        }
    }

}
