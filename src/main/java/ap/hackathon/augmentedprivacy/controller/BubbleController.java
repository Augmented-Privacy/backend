package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.AugmentedPrivacyApplication;
import ap.hackathon.augmentedprivacy.domain.presentation.Bubble;
import ap.hackathon.augmentedprivacy.domain.presentation.Customer;
import ap.hackathon.augmentedprivacy.generator.WordcloudGenerator;
import ap.hackathon.augmentedprivacy.helper.BubbleHelper;
import ap.hackathon.augmentedprivacy.helper.CustomerHelper;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import hex.genmodel.easy.exception.PredictException;
import jdk.nashorn.internal.runtime.Context;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
public class BubbleController {

    @RequestMapping("/bubbles")
    @CrossOrigin
    public List<Bubble> bubbles() throws PredictException {
        List<Bubble> bubbles = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            bubbles.add(bubble(i));
        }
        return bubbles;
    }

    @RequestMapping("/bubbles/{id}")
    @CrossOrigin
    public Bubble bubble(@PathVariable int id) throws PredictException {
        return BubbleHelper.getBubble(id);
    }

    @RequestMapping(value="/bubbles/wordcloud/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @CrossOrigin
    public ResponseEntity<byte[]> bubbleWc(@PathVariable int id) throws PredictException, IOException {


        Bubble bubble = BubbleHelper.getBubble(id);
        Map<String, Double> importance = bubble.getImportance();

        WordcloudGenerator wordcloudGenerator = new WordcloudGenerator();

        wordcloudGenerator.generate(importance, id);

        String format = String.format("%d.png", id);
        Resource resource = new ClassPathResource(format);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             InputStream input = resource.getInputStream();
        ) {
            org.apache.commons.io.IOUtils.copy(input, outputStream);
            return ResponseEntity.ok(outputStream.toByteArray());
        }
    }


    @RequestMapping("/bubbles/keywords/{keyword}")
    @CrossOrigin
    public List<Bubble> bubble(@PathVariable String keyword) throws PredictException {
        List<Bubble> topBubblesByKeyword = BubbleHelper.getTopBubblesByKeyword(keyword);
        Map<Integer, Bubble> bubblez = new HashMap<>();

        for (Bubble bubble: topBubblesByKeyword) {
            bubblez.put(bubble.getId(), bubble);
        }

        Set<String> retailCustomers = AugmentedPrivacyApplication.getRetailCustomers().keySet();
        for (String id : retailCustomers) {
            int bubbleId = CustomerHelper.getCustomerFomrRetailCustomer(id).getBubbleId();
            Bubble bubble = bubblez.get(bubbleId);
            if (bubble != null) {
                bubble.setNoCustomers(bubble.getNoCustomers() + 1);
            }
        }
        return topBubblesByKeyword;
    }

}
