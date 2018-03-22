package ap.hackathon.augmentedprivacy.generator;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.palette.ColorPalette;

import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class WordcloudGenerator {

    public void generate(Map<String, Double> buckets, int id) throws IOException {

        ArrayList<WordFrequency> wordFrequencies = new ArrayList<>();
                buckets.keySet().forEach(key -> wordFrequencies.add(new WordFrequency(key, (int)((((Double)(buckets.get(key))) + 1.0) * (((Double)(buckets.get(key))) + 1.0))   )));

        final Dimension dimension = new Dimension(300, 300);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(150));
        wordCloud.setBackgroundColor(Color.WHITE);
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
        wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src/main/resources/"+id+".png");
    }
}
