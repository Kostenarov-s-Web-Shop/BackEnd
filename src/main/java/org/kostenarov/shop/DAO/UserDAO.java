package org.kostenarov.shop.DAO;

import org.kostenarov.shop.DTO.UserDTO;
import org.kostenarov.shop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public List<User> findByRatingGreaterThanEqual(Double rating);
    public User save(User user);

}
