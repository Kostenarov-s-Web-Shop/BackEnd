package org.kostenarov.shop.Service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.kostenarov.shop.DAO.UserDAO;
import org.kostenarov.shop.DTO.UserDTO;
import org.kostenarov.shop.Entity.User;
import org.kostenarov.shop.Mapper.UserMapper;
import org.kostenarov.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.kostenarov.shop.Mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userRepository;

    @Override
    public List<UserDTO> findAll() {
        return USER_MAPPER.User_TO_UserDTO_SET(userRepository.findAll());
    }

    @Override
    public UserDTO findByUsername(String username) {
        return USER_MAPPER.User_TO_UserDTO(userRepository.findByUsername(username));
    }

    @Override
    public UserDTO findByEmail(String email) {
        return USER_MAPPER.User_TO_UserDTO(userRepository.findByEmail(email));
    }

    @Override
    public List<UserDTO> findByRatingGreaterThanEqual(Double rating) {
        return USER_MAPPER.User_TO_UserDTO_SET(userRepository.findByRatingGreaterThanEqual(rating));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if(findByUsername(userDTO.getUsername()) != null) {
            throw new RuntimeException("User with username " + userDTO.getUsername() + " exists");
        }
        return USER_MAPPER.User_TO_UserDTO(
                userRepository.save(
                        USER_MAPPER.UserDTO_TO_User(userDTO)
                )
        );
    }

    @Override
    public void delete(UserDTO userDTO) {
        userRepository.delete(
                USER_MAPPER.UserDTO_TO_User(userDTO)
        );
    }
}
