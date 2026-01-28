package org.kostenarov.shop.Service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.kostenarov.shop.DAO.CategoryDAO;
import org.kostenarov.shop.DTO.CategoryDTO;
import org.kostenarov.shop.Entity.Category;
import org.kostenarov.shop.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.kostenarov.shop.Mapper.CategoryMapper.CATEGORY_MAPPER;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryRepository;

    @Override
    public HashSet<CategoryDTO> findAll() {
        HashSet<Category> categorySet = new HashSet<>();
        categoryRepository.findAll().forEach(categorySet::add);
        return CATEGORY_MAPPER.Category_TO_CategoryDTO_SET(categorySet);
    }

    @Override
    public CategoryDTO findByName(String name) {
        return CATEGORY_MAPPER.Category_TO_CategoryDTO(
                categoryRepository.findByName(name));
    }

    @Override
    public CategoryDTO findById(Long id) {
        return CATEGORY_MAPPER.Category_TO_CategoryDTO(
                categoryRepository.findById(id).orElse(null));
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        if(findByName(categoryDTO.getName()) != null) {
            throw new RuntimeException("Category with name " + categoryDTO.getName() + " exists");
        }
        return CATEGORY_MAPPER.Category_TO_CategoryDTO(
                categoryRepository.save(
                        CATEGORY_MAPPER.CategoryDTO_TO_Category(categoryDTO)
                )
        );
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        categoryRepository.deleteByName(name);
    }
}
