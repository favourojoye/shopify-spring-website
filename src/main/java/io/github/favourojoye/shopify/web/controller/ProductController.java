package io.github.favourojoye.shopify.web.controller;


import io.github.favourojoye.shopify.model.Category;
import io.github.favourojoye.shopify.model.Product;
import io.github.favourojoye.shopify.services.CategoryService;
import io.github.favourojoye.shopify.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }



    @GetMapping("/products")
    public String getProducts(Model model) {
        return getProductsPage(model, productService.getAllProduct());
    }


    @GetMapping("/products-by-category")
    public String getProductByCategory(@RequestParam("categoryId") Long categoryId, Model model) {
        return getProductsPage(model, productService.getProductsByCategory(categoryId));
    }

    private String getProductsPage(Model model, List<Product> products) {
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getAllCategory());

        return "product-details";
    }

    @GetMapping("/add-product")
    public String getAddProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "add-product";
    }

    @PostMapping("/add-product")
    public String getAddProductPage(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }


    @GetMapping("/products-update/{id}")
    public String getProductUpdatePage(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }


}