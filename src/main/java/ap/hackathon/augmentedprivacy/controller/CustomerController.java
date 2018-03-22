package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.AugmentedPrivacyApplication;
import ap.hackathon.augmentedprivacy.domain.Bubble;
import ap.hackathon.augmentedprivacy.domain.RetailCustomer;
import ap.hackathon.augmentedprivacy.ml.kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d;
import hex.genmodel.GenModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.ClusteringModelPrediction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
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
    public Bubble index(@PathVariable String id) throws PredictException {
        GenModel rawModel = new kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d();
        EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);

        RetailCustomer retailCustomer = AugmentedPrivacyApplication.getCustomers().get(id);

        Map<String, BigDecimal> bucket = retailCustomer.getBucket();
        Map<String, Double> convertedBucket = new TreeMap<>();
        for (Map.Entry<String, BigDecimal> entry : bucket.entrySet()) {
            convertedBucket.put(entry.getKey(), entry.getValue().doubleValue());
        }

        Map<String, Integer> importance = new TreeMap<>();
        double[] means = kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d.getMeans();
        String[] names = kmeans_26607a20_9e61_407b_bb37_7f529ec5d76d.NAMES;
        for (int i = 0; i < means.length; i++) {
            Double aDouble = convertedBucket.get(names[i]);
            importance.put(names[i], (int) (100 * aDouble / means[i]));
        }

        RowData row = new RowData();
        row.putAll(convertedBucket);

        ClusteringModelPrediction clusteringModelPrediction = model.predictClustering(row);

        Bubble bubble = new Bubble();
        bubble.setBucket(bucket);
        bubble.setImportance(importance);
        bubble.setBubble(clusteringModelPrediction.cluster);
        return bubble;
    }

}
