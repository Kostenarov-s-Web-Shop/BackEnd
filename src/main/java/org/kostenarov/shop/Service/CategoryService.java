package org.kostenarov.shop.Service;

import org.kostenarov.shop.DTO.CategoryDTO;
import org.kostenarov.shop.Entity.Category;

import java.util.HashSet;
import java.util.List;

public interface CategoryService {
    public HashSet<CategoryDTO> findAll();
    public CategoryDTO findByName(String name);
    public CategoryDTO findById(Long id);
    public CategoryDTO save(CategoryDTO categoryDTO);
    public void deleteById(Long id);
    public void deleteByName(String name);
}
