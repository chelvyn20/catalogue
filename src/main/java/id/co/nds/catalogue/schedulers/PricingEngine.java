package id.co.nds.catalogue.schedulers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PricingEngine {

    static final Logger LOGGER = LogManager.getLogger(PricingEngine.class);
    private Double price;

    public Double getProductPrice() {
        return price;

    }

    @Scheduled(fixedDelay = 2000)
    public void computePrice() throws InterruptedException {
        LOGGER.info("Fixed delay: computing price at " +
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        // added sleep to simulate method
        // which takes longer to execute.
        Thread.sleep(4000);
    }

    @Scheduled(fixedRate = 3000)
    @Async
    public void refreshPricingParameters() {
        LOGGER.info("Fixed rate: computing price at " +
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

}