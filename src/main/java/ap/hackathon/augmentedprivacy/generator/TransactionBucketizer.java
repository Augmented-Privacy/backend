package ap.hackathon.augmentedprivacy.generator;

import ap.hackathon.augmentedprivacy.domain.Transaction;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TransactionBucketizer {

    @Getter
    Map<String, BigDecimal> buckets = new TreeMap<>();

    public void init() {
        Arrays.asList(Category.values()).forEach(category -> {
            buckets.put(category.name(), BigDecimal.ZERO);
        });
    }

    public void addTransaction(Transaction transaction) {
        String description = transaction.getDescription();
        Category category = Category.getCategoryFromDescription(description);
        BigDecimal acc = buckets.get(category.name());
        buckets.put(category.name(), acc.add(transaction.getAmount()));
    }

}
