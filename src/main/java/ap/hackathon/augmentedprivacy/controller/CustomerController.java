package ap.hackathon.augmentedprivacy.controller;

import ap.hackathon.augmentedprivacy.AugmentedPrivacyApplication;
import ap.hackathon.augmentedprivacy.domain.presentation.Customer;
import ap.hackathon.augmentedprivacy.helper.CustomerHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CustomerController {

    @RequestMapping("/customers")
    @CrossOrigin
    public Set<String> customers() {
        return AugmentedPrivacyApplication.getRetailCustomers().keySet();
    }

    @RequestMapping("/customers/{id}")
    @CrossOrigin
    public Customer customer(@PathVariable String id) {
        return CustomerHelper.getCustomerFomrRetailCustomer(id);
    }

}
