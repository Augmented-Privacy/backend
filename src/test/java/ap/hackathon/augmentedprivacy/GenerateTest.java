package ap.hackathon.augmentedprivacy;

import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.generator.Category;
import ap.hackathon.augmentedprivacy.generator.TransactionGenerator;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


public class GenerateTest {

    private TransactionGenerator transactionGenerator = new TransactionGenerator();

    @Test
    public void testGenerate() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        // Headers
        stringBuilder.append("Name").append(",");
        String header = Arrays.stream(Category.values()).map(Enum::name).sorted().collect(Collectors.joining(","));
        stringBuilder.append(header);
        stringBuilder.append('\n');

        // 100 Customers
        for (int i = 0; i < 100; i++) {
            RetailCustomer retailCustomer = new RetailCustomer();
            retailCustomer.setName(RandomString.make(6));
            retailCustomer.setTransactions(transactionGenerator.generate100Transactions());

            stringBuilder.append(retailCustomer.toString());
        }

        Files.write(Paths.get("./output.csv"), stringBuilder.toString().getBytes());
    }
}
