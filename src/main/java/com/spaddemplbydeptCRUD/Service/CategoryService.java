package com.spaddemplbydeptCRUD.Service;

import com.spaddemplbydeptCRUD.Model.Category;
import com.spaddemplbydeptCRUD.Repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService  {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategory() {
        logger.info("Retrieving all Category from the database");
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            logger.warn("No Category found in the database");
        } else {
            logger.info("Retrieved {} Category", categories.size());
        }
        return categories;
    }
}

