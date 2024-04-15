package com.spaddemplbydeptCRUD.Service;

import com.spaddemplbydeptCRUD.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProduct();

    List<Product> getProductByCategory(Long departmentId);
Product getProductById(long id);
    void addProduct(Product product);

    void deleteProducteById(long id);



}