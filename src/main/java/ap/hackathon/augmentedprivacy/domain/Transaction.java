package ap.hackathon.augmentedprivacy.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Transaction {

    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("y-MM-dd");
    private String description;
    private BigInteger amount;
    private Date transactionDate;
    private MutationType mutationType;

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(description).append(",").
                append(amount).append(",").
                append(DATE_FORMATTER.format(transactionDate)).append(",").
                append(mutationType).append('\n');
        return stringBuffer.toString();
    }

}
