package com.wongdarren;

import com.wongdarren.service.ProductService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ProductScheduler {

    private static final Logger LOGGER = Logger.getLogger(ProductScheduler.class);

    @Inject
    ProductService productService;

    /**
     * This method is scheduled to run every minute.
     * The @Scheduled annotation is used to define the schedule.
     * <p>
     * Every 10 seconds: @Scheduled(every = "10s")
     * Every 2 hours: @Scheduled(every = "2h")
     * Every 1 hour and 30 minutes: @Scheduled(every = "1h30m")
     */
    @Scheduled(every = "10s")
    void addRandomProduct() {
        LOGGER.info("Adding a product...");
        try {
            productService.generateAndSaveProduct();
            LOGGER.trace("Product added successfully");
        } catch (Exception e) {
            LOGGER.errorf(e, "Error occurred while adding a product");
        }
        LOGGER.info("Product added...");
    }
}