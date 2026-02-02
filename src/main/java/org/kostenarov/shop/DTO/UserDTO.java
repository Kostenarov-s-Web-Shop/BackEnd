package org.kostenarov.shop.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Double rating;
    private String password;
    private String firstName;
    private String lastName;
    private List<ListingDTO> listings;
}
