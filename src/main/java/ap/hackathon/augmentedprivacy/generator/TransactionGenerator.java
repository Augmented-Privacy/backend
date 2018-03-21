package ap.hackathon.augmentedprivacy.generator;

import ap.hackathon.augmentedprivacy.domain.MutationType;
import ap.hackathon.augmentedprivacy.domain.Transaction;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TransactionGenerator {

    public List<Transaction> generate100Transactions() {
        List<Transaction> transactions = new ArrayList<>();

        Category primaryCategory = Category.getRandom();
        Category secondaryCategory = Category.getRandom();
        Category tertiaryCategory = Category.getRandom();

        for (int i = 0; i < 20; i++) {
            transactions.add(generateTransactionFromCategory(primaryCategory));
        }
        for (int i = 0; i < 15; i++) {
            transactions.add(generateTransactionFromCategory(secondaryCategory));
        }
        for (int i = 0; i < 10; i++) {
            transactions.add(generateTransactionFromCategory(tertiaryCategory));
        }
        for (int i = 0; i < 55; i++) {
            transactions.add(generateTransaction());
        }
        return  transactions;
    }

    public Transaction generateTransactionFromCategory(Category category) {
        Transaction transaction = new Transaction();

        transaction.setAmount(category.getAmount());
        transaction.setDescription(category.getRandomKeyword());

        long minDay = LocalDate.of(2018, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        Date date = Date.from(randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        transaction.setTransactionDate(date);
        transaction.setMutationType(MutationType.PIN);
        return transaction;
    }

    public Transaction generateTransaction() {
      return generateTransactionFromCategory(Category.getRandom());
    }



}
