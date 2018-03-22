package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.domain.presentation.Bubble;
import ap.hackathon.augmentedprivacy.ml.kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.TreeMap;

public class BubbleHelper {

    public static Bubble getBubble(int id) {
        Map<String, Double> importance = new TreeMap<>();
        double[][] kMeans = kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4.getKMeans();
        double[] kMean = kMeans[id];
        String[] names = kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4.NAMES;

        for (int i = 0; i < names.length; i++) {
            importance.put(names[i], kMean[i]);
        }

        Bubble bubble = new Bubble();
        bubble.setImportance(importance);
        return bubble;
    }

}
