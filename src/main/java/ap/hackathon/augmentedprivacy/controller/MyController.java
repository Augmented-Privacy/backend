package ap.hackathon.augmentedprivacy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

