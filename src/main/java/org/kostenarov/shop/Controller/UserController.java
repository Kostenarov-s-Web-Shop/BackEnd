package org.kostenarov.shop.Controller;

import lombok.RequiredArgsConstructor;
import org.kostenarov.shop.DTO.UserDTO;
import org.kostenarov.shop.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/createAdmin")
    public String createAdmin() {
        return "Admin created";
    }

    @PostMapping("/createUser")
    ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.save(userDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO);
        return ResponseEntity.ok("User with username " + userDTO.getUsername() + " deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getUsersByRatingGreaterThanEqual(@PathVariable Double rating) {
        return ResponseEntity.ok(userService.findByRatingGreaterThanEqual(rating));
    }
}

