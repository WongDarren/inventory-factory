// src/main/java/com/wongdarren/repository/ProductRepository.java
package com.wongdarren.repository;

import com.wongdarren.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    private static final Logger LOGGER = Logger.getLogger(ProductRepository.class);

    /**
     * Add a product to the database.
     *
     * @param product The product to add
     */
    @Transactional
    public void addProduct(Product product) {
        LOGGER.infof("Persisting product: %s", product);
        try {
            persist(product);
        } catch (Exception e) {
            LOGGER.errorf(e, "Error occurred while persisting product: %s", product);
        }
    }
}