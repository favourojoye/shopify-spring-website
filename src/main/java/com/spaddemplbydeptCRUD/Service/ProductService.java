package com.spaddemplbydeptCRUD.Service;

import com.spaddemplbydeptCRUD.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProduct();

    List<Product> getProductsByCategory(Long categoryId);

    Product getProductById(long id);

    void addProduct(Product product);

    void deleteProductById(long id);


}