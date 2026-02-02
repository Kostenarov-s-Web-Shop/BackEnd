package org.kostenarov.shop.Service;

import org.kostenarov.shop.DTO.UserDTO;
import org.kostenarov.shop.Entity.User;

import java.util.List;

public interface UserService {
    public List<UserDTO> findAll();
    public UserDTO findByUsername(String username);
    public UserDTO findByEmail(String email);
    public List<UserDTO> findByRatingGreaterThanEqual(Double rating);
    public UserDTO save(UserDTO userDTO);
    public void delete(UserDTO userDTO);
}
