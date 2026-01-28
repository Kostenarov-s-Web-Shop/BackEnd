package org.kostenarov.shop.Controller;

import lombok.RequiredArgsConstructor;
import org.kostenarov.shop.DTO.CategoryDTO;
import org.kostenarov.shop.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        try{
            return ResponseEntity.ok(categoryService.save(categoryDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Category with id " + id + " deleted");
    }

    @DeleteMapping("/delete/name/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCategoryByName(@PathVariable String name) {
        categoryService.deleteByName(name);
        return ResponseEntity.ok("Category with name " + name + " deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
}
