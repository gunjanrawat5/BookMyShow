package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.UserNotFoundException;
import dev.gunjan.BookMyShow.model.User;
import dev.gunjan.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with given id not found")
        );
    }

}
