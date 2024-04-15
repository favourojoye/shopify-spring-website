package com.spaddemplbydeptCRUD.Repository;


import com.spaddemplbydeptCRUD.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
