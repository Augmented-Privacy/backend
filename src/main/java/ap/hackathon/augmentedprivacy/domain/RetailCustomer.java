package ap.hackathon.augmentedprivacy.domain;

import ap.hackathon.augmentedprivacy.generator.TransactionBucketizer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class RetailCustomer {

    private String name;
    private List<Transaction> transactions;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(",");

        TransactionBucketizer transactionBucketizer = new TransactionBucketizer();
        transactionBucketizer.init();

        transactions.forEach(transactionBucketizer::addTransaction);

        Map<String, BigDecimal> buckets = transactionBucketizer.getBuckets();
        String values = buckets.entrySet().stream().map(a -> a.getValue().toString()).collect(Collectors.joining(","));
        stringBuilder.append(values);

        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    public Map<String, BigDecimal> getBucket() {
        TransactionBucketizer transactionBucketizer = new TransactionBucketizer();
        transactionBucketizer.init();
        transactions.forEach(transactionBucketizer::addTransaction);
        return transactionBucketizer.getBuckets();
    }

}
