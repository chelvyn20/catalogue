package id.co.nds.catalogue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.catalogue.schedulers.PricingEngine;

@RestController
@EnableScheduling
@RequestMapping("/scheduler")
public class SchedulerController {
    @Autowired
    PricingEngine pricingEngine;

    @PostMapping("/computer")
    public void postSchedule() {
        try {
            pricingEngine.computePrice();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @PostMapping("/refresh")
    public void refreshPricing() {
        pricingEngine.refreshPricingParameters();
    }
}
