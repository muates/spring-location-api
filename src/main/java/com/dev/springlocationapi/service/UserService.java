package com.dev.springlocationapi.service;

import com.dev.springlocationapi.domain.User;
import com.dev.springlocationapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.getById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUserById(Long id, User user){
        User existUser = getUserById(id);

        if(existUser == null){
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existUser.setName(user.getName());
        existUser.setSurname(user.getSurname());
        existUser.seteMail(user.geteMail());
        existUser.setAddress(user.getAddress());

        userRepository.save(existUser);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
