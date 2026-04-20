package dev.gunjan.BookMyShow.controller;

import dev.gunjan.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
