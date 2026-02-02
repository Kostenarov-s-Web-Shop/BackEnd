package org.kostenarov.shop.Mapper;

import org.kostenarov.shop.DTO.UserDTO;
import org.kostenarov.shop.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO User_TO_UserDTO(User user);
    User UserDTO_TO_User(UserDTO userDTO);
    List<UserDTO> User_TO_UserDTO_SET(List<User> userList);
    List<User> UserDTO_TO_User_SET(List<UserDTO> userDTOList);
}
