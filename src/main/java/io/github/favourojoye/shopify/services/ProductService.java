package io.github.favourojoye.shopify.services;

import io.github.favourojoye.shopify.model.Category;
import io.github.favourojoye.shopify.model.Product;
import io.github.favourojoye.shopify.repositories.CategoryRepository;
import io.github.favourojoye.shopify.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CategoryRepository categoryRepository;


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + categoryId));
        return category.getProducts();
    }

    public void addProduct(Product product) {
        // You might want to validate the employee data before saving it
        productRepository.save(product);

    }

    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        productRepository.delete(product);
    }
}
