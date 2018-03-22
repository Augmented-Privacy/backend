package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.AugmentedPrivacyApplication;
import ap.hackathon.augmentedprivacy.domain.presentation.Bubble;
import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.domain.presentation.Customer;
import ap.hackathon.augmentedprivacy.ml.kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d;
import ap.hackathon.augmentedprivacy.ml.kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4;
import hex.genmodel.GenModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.ClusteringModelPrediction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@RestController
public class CustomerController {

    @RequestMapping("/customers")
    public Set<String> customers() throws PredictException {
        return AugmentedPrivacyApplication.getCustomers().keySet();
    }

    @RequestMapping("/customers/{id}")
    public Customer index(@PathVariable String id) throws PredictException {
        GenModel rawModel = new kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4();
        EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);

        RetailCustomer retailCustomer = AugmentedPrivacyApplication.getCustomers().get(id);

        Map<String, BigDecimal> bucket = retailCustomer.getBucket();
        Map<String, Double> convertedBucket = new TreeMap<>();
        for (Map.Entry<String, BigDecimal> entry : bucket.entrySet()) {
            convertedBucket.put(entry.getKey(), entry.getValue().doubleValue());
        }

        RowData row = new RowData();
        row.putAll(convertedBucket);

        ClusteringModelPrediction clusteringModelPrediction = model.predictClustering(row);

        Customer customer = new Customer();
        customer.setBucket(bucket);
        customer.setBubbleId(clusteringModelPrediction.cluster);
        customer.setBubble(BubbleHelper.getBubble(clusteringModelPrediction.cluster));
        return customer;
    }

}
