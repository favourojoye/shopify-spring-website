package com.spaddemplbydeptCRUD.Repository;

import com.spaddemplbydeptCRUD.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
