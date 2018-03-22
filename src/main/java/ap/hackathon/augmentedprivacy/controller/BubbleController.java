package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.domain.presentation.Bubble;
import ap.hackathon.augmentedprivacy.helper.BubbleHelper;
import hex.genmodel.easy.exception.PredictException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BubbleController {

    @RequestMapping("/bubbles")
    public List<Bubble> bubbles() throws PredictException {
        List<Bubble> bubbles = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            bubbles.add(bubble(i));
        }
        return bubbles;
    }

    @RequestMapping("/bubbles/{id}")
    public Bubble bubble(@PathVariable int id) throws PredictException {
        return BubbleHelper.getBubble(id);
    }

    @RequestMapping("/bubbles/keywords/{keyword}")
    public List<Bubble> bubble(@PathVariable String keyword) throws PredictException {
        return BubbleHelper.getTopBubblesByKeyword(keyword);
    }

}
