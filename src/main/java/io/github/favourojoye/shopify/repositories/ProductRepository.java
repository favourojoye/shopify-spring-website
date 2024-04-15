package io.github.favourojoye.shopify.repositories;


import io.github.favourojoye.shopify.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
