package ap.hackathon.augmentedprivacy.helper;

import ap.hackathon.augmentedprivacy.domain.presentation.Bubble;
import ap.hackathon.augmentedprivacy.ml.kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4;

import java.util.*;

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
        bubble.setId(id);
        return bubble;
    }

    public static List<Bubble> getTopBubblesByKeyword(String keyword) {
        List<Bubble> returnedBubbles = new ArrayList<>();
        String[] names = kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4.NAMES;
        double[][] kMeans = kmeans_8fac4864_63c2_4bf4_a193_a2a32c0013e4.getKMeans();
        double[] kMeanUnsorted = new double[16];
        double[] kMeanSorted = new double[16];

        int indexOfKeywordColumn = getArrayIndex(names, keyword);

        for (int i = 0; i < names.length; i++) {
            kMeanUnsorted[i] = kMeans[i][indexOfKeywordColumn]; // Dit zijn alle mean waardes voor dit keyword
        }

        System.arraycopy(kMeanUnsorted, 0, kMeanSorted, 0, kMeanUnsorted.length);
        Arrays.sort(kMeanSorted);

        double[] topThreeBubbleMeans = Arrays.copyOfRange(kMeanSorted, kMeanSorted.length - 3, kMeanSorted.length);
        reverse(topThreeBubbleMeans);

        for (int i = 0; i < topThreeBubbleMeans.length; i++) {
            returnedBubbles.add(i, getBubble(getArrayIndex(kMeanUnsorted, topThreeBubbleMeans[i])));
        }

        return returnedBubbles;
    }

    private static int getArrayIndex(double[] arr, double value) {

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                k = i;
                break;
            }
        }
        return k;
    }

    private static int getArrayIndex(String[] arr, String value) {

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].equalsIgnoreCase(value)) {
                k = i;
                break;
            }
        }
        return k;
    }

    private static void reverse(double[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            double temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }

    }

}
