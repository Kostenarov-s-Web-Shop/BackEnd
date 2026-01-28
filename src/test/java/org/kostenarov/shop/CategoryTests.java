package org.kostenarov.shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kostenarov.shop.Controller.CategoryController;
import org.kostenarov.shop.DTO.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
public class CategoryTests {
    @Autowired
    private CategoryController categoryController;
    @BeforeEach
    public void setup() {
        categoryController.createCategory(new CategoryDTO() {{;
            setName("Electronics");
        }});

        categoryController.createCategory(new CategoryDTO() {{
            setName("Books");
        }});

        categoryController.createCategory(new CategoryDTO() {{
            setName("Clothing");
        }});
    }

    @Test
    public void testGetAllCategories() {
        var response = categoryController.getAllCategories();
        Assertions.assertNotNull(response.getBody());
        var categories = (java.util.List<?>) response.getBody();
        Assertions.assertEquals(3, categories.size());
    }

    @Test
    public void testGetCategoryByName() {
        var response = categoryController.getCategoryByName("Books");
        Assertions.assertNotNull(response.getBody());
        var category = (CategoryDTO) response.getBody();
        Assertions.assertEquals("Books", category.getName());
    }

    @Test
    public void testDeleteCategoryByName() {
        var deleteResponse = categoryController.deleteCategoryByName("Clothing");
        Assertions.assertEquals(200, deleteResponse.getStatusCode());
    }

    @Test
    public void testCreateCategory() {
        var response = categoryController.createCategory(new CategoryDTO() {{
            setName("Toys");
        }});
        Assertions.assertNotNull(response.getBody());
        var category = (CategoryDTO) response.getBody();
        Assertions.assertEquals("Toys", category.getName());
        response = categoryController.getAllCategories();
        Assertions.assertNotNull(response.getBody());
        var categories = (java.util.List<?>) response.getBody();
        Assertions.assertEquals(3, categories.size());
    }

    @Test
    public void testCreateDuplicateCategory() {
        var response = categoryController.createCategory(new CategoryDTO() {{
            setName("Electronics");
        }});
        Assertions.assertEquals(400, response.getStatusCode());
    }

    @AfterEach
    public void cleanup() {
        categoryController.deleteCategoryByName("Electronics");
        categoryController.deleteCategoryByName("Books");
        categoryController.deleteCategoryByName("Clothing");
    }
}
