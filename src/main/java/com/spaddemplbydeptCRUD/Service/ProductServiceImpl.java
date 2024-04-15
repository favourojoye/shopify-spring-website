package com.spaddemplbydeptCRUD.Service;

import com.spaddemplbydeptCRUD.Model.Category;
import com.spaddemplbydeptCRUD.Model.Product;
import com.spaddemplbydeptCRUD.Repository.CategoryRepository;
import com.spaddemplbydeptCRUD.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CategoryRepository categoryRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + categoryId));
        return category.getProducts();
    }
    @Override
    public void addProduct(Product product) {
        // You might want to validate the employee data before saving it
        productRepository.save(product);

    }
    @Override
    public Product getProductById(long id) {
        // Retrieve the employee by ID
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    public void deleteProductById(long id) {
        // Retrieve the employee by ID
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Delete the employee
        productRepository.delete(product);
    }
}
