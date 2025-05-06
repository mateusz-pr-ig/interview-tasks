package com.infogain.interview.task4;

import com.infogain.interview.task4.api.User;
import com.infogain.interview.task4.api.UserDto;
import com.infogain.interview.task4.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        userRepository.save(user);
        return "User created";
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userRepository.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
      List<UserDto> users = userRepository.getAllUsers();
      return ResponseEntity.ok(users);
    }
}