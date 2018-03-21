package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.generator.TransactionGenerator;
import ap.hackathon.augmentedprivacy.ml.kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d;
import hex.genmodel.GenModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.ClusteringModelPrediction;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class MyController {

    TransactionGenerator transactionGenerator = new TransactionGenerator();

    @RequestMapping("/")
    public String index() throws PredictException {
        GenModel rawModel = new kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d();
        EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);

        RetailCustomer retailCustomer = new RetailCustomer();
        retailCustomer.setName(RandomString.make(6));
        retailCustomer.setTransactions(transactionGenerator.generate100Transactions());
        Map<String, BigDecimal> bucket = retailCustomer.getBucket();
        Map<String, Double> convertedBucket = new TreeMap<>();
        for (Map.Entry<String, BigDecimal> entry : bucket.entrySet()) {
            convertedBucket.put(entry.getKey(), entry.getValue().doubleValue());
        }

        RowData row = new RowData();
        row.putAll(convertedBucket);

        ClusteringModelPrediction clusteringModelPrediction = model.predictClustering(row);

        return "U zit in bubbel " + clusteringModelPrediction.cluster;
    }

}

