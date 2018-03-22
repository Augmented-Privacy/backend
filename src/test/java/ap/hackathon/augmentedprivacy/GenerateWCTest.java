package ap.hackathon.augmentedprivacy;

import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.generator.Category;
import ap.hackathon.augmentedprivacy.generator.TransactionGenerator;
import ap.hackathon.augmentedprivacy.generator.WordcloudGenerator;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class GenerateWCTest {

    private WordcloudGenerator wordcloudGenerator = new WordcloudGenerator();

    @Test
    public void testGenerate() throws IOException {

        Map<String, BigDecimal> buckets = new TreeMap<>();

        /*
        sa[0] = "BABY_ARTIKELEN";
      sa[1] = "BELASTINGEN";
      sa[2] = "ELEKTRONICA_WINKELS";
      sa[3] = "FAMILIELEDEN";
      sa[4] = "GOEDE_DOELEN";
      sa[5] = "HORECA";
      sa[6] = "HUUR";
      sa[7] = "HYPOTHEEKAFSCHRIJVINGEN";
      sa[8] = "LEESMATERIAAL";
      sa[9] = "MODEWINKELS";
      sa[10] = "NUTSBEDRIJVEN";
      sa[11] = "SPAREN";
      sa[12] = "SPORT_ARTIKELEN";
      sa[13] = "SUPERMARKTEN";
      sa[14] = "TANKEN";
      sa[15] = "TELECOMBEDRIJVEN";
         */
        buckets.put("BABY_ARTIKELEN", BigDecimal.valueOf(-0.4153));
        buckets.put("BELASTINGEN", BigDecimal.valueOf(2.6073));
        buckets.put("ELEKTRONICA_WINKELS", BigDecimal.valueOf(-0.7422));
        buckets.put("FAMILIELEDEN", BigDecimal.valueOf(0.8752));
        buckets.put("GOEDE_DOELEN", BigDecimal.valueOf(-0.0812));
        buckets.put("HORECA", BigDecimal.valueOf(-0.3816));
        buckets.put("HUUR", BigDecimal.valueOf(-0.3933));
        buckets.put("HYPOTHEEKAFSCHRIJVINGEN", BigDecimal.valueOf(1.8689));
        buckets.put("LEESMATERIAAL", BigDecimal.valueOf(-0.2389));
        buckets.put("MODEWINKELS", BigDecimal.valueOf(-0.4865));
        buckets.put("NUTSBEDRIJVEN", BigDecimal.valueOf(-0.4125));
        buckets.put("SPAREN", BigDecimal.valueOf(-0.3745));
        buckets.put("SPORT_ARTIKELEN", BigDecimal.valueOf(-0.7122));
        buckets.put("SUPERMARKTEN", BigDecimal.valueOf(-0.0552));
        buckets.put("TANKEN", BigDecimal.valueOf(1.9161));
        buckets.put("TELECOMBEDRIJVEN", BigDecimal.valueOf(-0.0664));


        wordcloudGenerator.generate(buckets);
        System.out.println("yes");

    }
}
