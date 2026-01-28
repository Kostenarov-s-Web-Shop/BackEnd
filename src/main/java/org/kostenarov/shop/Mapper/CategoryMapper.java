package org.kostenarov.shop.Mapper;

import org.kostenarov.shop.DTO.CategoryDTO;
import org.kostenarov.shop.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;

@Mapper
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO Category_TO_CategoryDTO(Category category);
    Category CategoryDTO_TO_Category(CategoryDTO categoryDTO);
    HashSet<CategoryDTO> Category_TO_CategoryDTO_SET(HashSet<Category> categorySet);
    HashSet<Category> CategoryDTO_TO_Category_SET(HashSet<CategoryDTO> categoryDTOSet);

}
