package com.wongdarren;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class ProductScheduler {

    private static final String[] PRODUCTS = {"Product A", "Product B", "Product C", "Product D"};

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
        Random random = new Random();
        String product = PRODUCTS[random.nextInt(PRODUCTS.length)];
        System.out.println("Adding product: " + product);
    }
}