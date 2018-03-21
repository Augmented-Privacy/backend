package ap.hackathon.augmentedprivacy.generator;

import ap.hackathon.augmentedprivacy.domain.Transaction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class TransactionBucketizer {

    Map<String, BigDecimal> buckets;

    public void init() {
        Arrays.asList(Category.values()).forEach(category -> {
            buckets.put(category.name(), BigDecimal.ZERO);
        });
    }

    public void addTransaction(Transaction transaction) {
//        buckets.put(transaction.)
    }

}
