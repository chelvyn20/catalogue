package id.co.nds.catalogue;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
// import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
// @EnableScheduling
public class CatalogueApplication {
    // private static final Logger logger = LogManager.getLogger(CatalogueApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CatalogueApplication.class, args);
    }

    // @Scheduled(initialDelay = 1000, fixedRate = 10000)
    // public void run() {
    //     logger.info("Current time is :: " + Calendar.getInstance().getTime());
    // }

}
