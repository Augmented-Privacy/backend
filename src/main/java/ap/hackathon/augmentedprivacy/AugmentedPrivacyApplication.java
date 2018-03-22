package ap.hackathon.augmentedprivacy;

import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.generator.TransactionGenerator;
import lombok.Getter;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AugmentedPrivacyApplication {

    private static TransactionGenerator transactionGenerator = new TransactionGenerator();

    @Getter
    private static Map<String, RetailCustomer> customers = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(AugmentedPrivacyApplication.class, args);

        // Generate customers
        for (int i = 0; i < 100; i++) {
            RetailCustomer retailCustomer = new RetailCustomer();
            retailCustomer.setName(RandomString.make(6));
            retailCustomer.setTransactions(transactionGenerator.generate100Transactions());
            customers.put(retailCustomer.getName(), retailCustomer);
        }
    }

}
