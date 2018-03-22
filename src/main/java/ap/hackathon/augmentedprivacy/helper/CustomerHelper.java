package ap.hackathon.augmentedprivacy.helper;

import ap.hackathon.augmentedprivacy.AugmentedPrivacyApplication;
import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.domain.presentation.Customer;
import ap.hackathon.augmentedprivacy.ml.kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4;
import hex.genmodel.GenModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.ClusteringModelPrediction;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class CustomerHelper {

    public static Customer getCustomerFomrRetailCustomer(String id)  {
        GenModel rawModel = new kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4();
        EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);

        RetailCustomer retailCustomer = AugmentedPrivacyApplication.getRetailCustomers().get(id);

        Map<String, BigDecimal> bucket = retailCustomer.getBucket();
        Map<String, Double> convertedBucket = new TreeMap<>();
        for (Map.Entry<String, BigDecimal> entry : bucket.entrySet()) {
            convertedBucket.put(entry.getKey(), entry.getValue().doubleValue());
        }

        RowData row = new RowData();
        row.putAll(convertedBucket);

        ClusteringModelPrediction clusteringModelPrediction = null;
        try {
            clusteringModelPrediction = model.predictClustering(row);
        } catch (PredictException e) {
            e.printStackTrace();
        }

        Customer customer = new Customer();
        customer.setBucket(bucket);
        customer.setBubbleId(clusteringModelPrediction.cluster);
        customer.setBubble(BubbleHelper.getBubble(clusteringModelPrediction.cluster));
        return customer;
    }
}
