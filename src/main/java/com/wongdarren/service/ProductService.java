package com.wongdarren.service;

import com.wongdarren.entity.Product;
import com.wongdarren.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService.class);

    @Inject
    ProductRepository productRepository;

    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product("Women's Outerwear", "Description for Women's Outerwear", BigDecimal.valueOf(79.99), 1, "Outerwear", "Women", "M", "Red"),
            new Product("Women's Sweater", "Description for Women's Sweater", BigDecimal.valueOf(49.99), 1, "Sweater", "Women", "L", "Blue"),
            new Product("Women's Cardigan", "Description for Women's Cardigan", BigDecimal.valueOf(49.99), 1, "Cardigan", "Women", "L", "Green"),
            new Product("Women's T-Shirt", "Description for Women's T-Shirt", BigDecimal.valueOf(29.99), 1, "T-Shirt", "Women", "S", "Yellow"),
            new Product("Women's Sweat", "Description for Women's Sweat", BigDecimal.valueOf(29.99), 1, "Sweat", "Women", "S", "Pink"),
            new Product("Women's Fleece", "Description for Women's Fleece", BigDecimal.valueOf(29.99), 1, "Fleece", "Women", "S", "Purple"),
            new Product("Women's Shirt", "Description for Women's Shirt", BigDecimal.valueOf(39.99), 1, "Shirt", "Women", "M", "Orange"),
            new Product("Women's Blouse", "Description for Women's Blouse", BigDecimal.valueOf(39.99), 1, "Blouse", "Women", "M", "White"),
            new Product("Women's Dress", "Description for Women's Dress", BigDecimal.valueOf(59.99), 1, "Dress", "Women", "L", "Black"),
            new Product("Women's Skirt", "Description for Women's Skirt", BigDecimal.valueOf(39.99), 1, "Skirt", "Women", "M", "Gray"),
            new Product("Women's Bottom", "Description for Women's Bottom", BigDecimal.valueOf(49.99), 1, "Bottom", "Women", "L", "Brown"),
            new Product("Women's Innerwear", "Description for Women's Innerwear", BigDecimal.valueOf(19.99), 1, "Innerwear", "Women", "S", "Beige"),
            new Product("Women's Underwear", "Description for Women's Underwear", BigDecimal.valueOf(19.99), 1, "Underwear", "Women", "S", "Navy"),
            new Product("Women's Loungewear", "Description for Women's Loungewear", BigDecimal.valueOf(29.99), 1, "Loungewear", "Women", "M", "Teal"),
            new Product("Women's Home", "Description for Women's Home", BigDecimal.valueOf(29.99), 1, "Home", "Women", "M", "Maroon"),
            new Product("Women's Accessory", "Description for Women's Accessory", BigDecimal.valueOf(19.99), 1, "Accessory", "Women", "One Size", "Gold"),
            new Product("Men's Outerwear", "Description for Men's Outerwear", BigDecimal.valueOf(89.99), 1, "Outerwear", "Men", "XL", "Black"),
            new Product("Men's Sweater", "Description for Men's Sweater", BigDecimal.valueOf(59.99), 1, "Sweater", "Men", "M", "Gray"),
            new Product("Men's Cardigan", "Description for Men's Cardigan", BigDecimal.valueOf(59.99), 1, "Cardigan", "Men", "M", "Green"),
            new Product("Men's T-Shirt", "Description for Men's T-Shirt", BigDecimal.valueOf(19.99), 1, "T-Shirt", "Men", "L", "White"),
            new Product("Men's Sweat", "Description for Men's Sweat", BigDecimal.valueOf(19.99), 1, "Sweat", "Men", "L", "Blue"),
            new Product("Men's Fleece", "Description for Men's Fleece", BigDecimal.valueOf(19.99), 1, "Fleece", "Men", "L", "Red"),
            new Product("Men's Shirt", "Description for Men's Shirt", BigDecimal.valueOf(39.99), 1, "Shirt", "Men", "M", "Yellow"),
            new Product("Men's Polo", "Description for Men's Polo", BigDecimal.valueOf(39.99), 1, "Polo", "Men", "M", "Pink"),
            new Product("Men's Bottom", "Description for Men's Bottom", BigDecimal.valueOf(49.99), 1, "Bottom", "Men", "L", "Brown"),
            new Product("Men's Innerwear", "Description for Men's Innerwear", BigDecimal.valueOf(19.99), 1, "Innerwear", "Men", "S", "Beige"),
            new Product("Men's Underwear", "Description for Men's Underwear", BigDecimal.valueOf(19.99), 1, "Underwear", "Men", "S", "Navy"),
            new Product("Men's Loungewear", "Description for Men's Loungewear", BigDecimal.valueOf(29.99), 1, "Loungewear", "Men", "M", "Teal"),
            new Product("Men's Home", "Description for Men's Home", BigDecimal.valueOf(29.99), 1, "Home", "Men", "M", "Maroon"),
            new Product("Men's Accessory", "Description for Men's Accessory", BigDecimal.valueOf(19.99), 1, "Accessory", "Men", "One Size", "Gold"),
            new Product("Kids' Outerwear", "Description for Kids' Outerwear", BigDecimal.valueOf(39.99), 1, "Outerwear", "Kids", "M", "Yellow"),
            new Product("Kids' T-Shirt", "Description for Kids' T-Shirt", BigDecimal.valueOf(24.99), 1, "T-Shirt", "Kids", "S", "Pink"),
            new Product("Kids' Sweat", "Description for Kids' Sweat", BigDecimal.valueOf(24.99), 1, "Sweat", "Kids", "S", "Purple"),
            new Product("Kids' Fleece", "Description for Kids' Fleece", BigDecimal.valueOf(24.99), 1, "Fleece", "Kids", "S", "Orange"),
            new Product("Kids' Sweater", "Description for Kids' Sweater", BigDecimal.valueOf(24.99), 1, "Sweater", "Kids", "S", "White"),
            new Product("Kids' Cardigan", "Description for Kids' Cardigan", BigDecimal.valueOf(24.99), 1, "Cardigan", "Kids", "S", "Black"),
            new Product("Kids' Shirt", "Description for Kids' Shirt", BigDecimal.valueOf(24.99), 1, "Shirt", "Kids", "S", "Gray"),
            new Product("Kids' Blouse", "Description for Kids' Blouse", BigDecimal.valueOf(24.99), 1, "Blouse", "Kids", "S", "Green"),
            new Product("Kids' Bottom", "Description for Kids' Bottom", BigDecimal.valueOf(24.99), 1, "Bottom", "Kids", "S", "Blue"),
            new Product("Kids' Dress", "Description for Kids' Dress", BigDecimal.valueOf(24.99), 1, "Dress", "Kids", "S", "Red"),
            new Product("Kids' Innerwear", "Description for Kids' Innerwear", BigDecimal.valueOf(24.99), 1, "Innerwear", "Kids", "S", "Yellow"),
            new Product("Kids' Underwear", "Description for Kids' Underwear", BigDecimal.valueOf(24.99), 1, "Underwear", "Kids", "S", "Pink"),
            new Product("Kids' Loungewear", "Description for Kids' Loungewear", BigDecimal.valueOf(24.99), 1, "Loungewear", "Kids", "S", "Purple"),
            new Product("Kids' Home", "Description for Kids' Home", BigDecimal.valueOf(24.99), 1, "Home", "Kids", "S", "Orange"),
            new Product("Kids' Accessory", "Description for Kids' Accessory", BigDecimal.valueOf(24.99), 1, "Accessory", "Kids", "One Size", "White")
    );

    /**
     * Generates a random product from the list of products and saves it to the database.
     */
    public void generateAndSaveProduct() {
        LOGGER.info("Generating and saving a random product");

        Random random = new Random();
        Product product = PRODUCTS.get(random.nextInt(PRODUCTS.size()));

        if (product.getCreatedAt() == null) {
            product.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        }
        product.setUpdatedAt(LocalDateTime.now(ZoneOffset.UTC));

        try {
            productRepository.addProduct(product);
        } catch (Exception e) {
            LOGGER.error("Error occurred while saving product: " + product, e);
        }
    }
}