package org.kostenarov.shop.DAO;

import org.kostenarov.shop.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
    public Category findByName(String name);
    public List<Category> findAll();
    public void deleteByName(String name);
}
