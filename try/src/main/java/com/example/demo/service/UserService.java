package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.api.model.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<User>();
        userList.add(new User("Thalinhos", 24));   
        userList.add(new User("Carolinda", 21));
        userList.add(new User("Amandoca", 25));
        userList.add(new User("vovozinha dona leda", 84));
    }

    public Optional<User> getUser(int id) {
        Optional<User> optional = Optional.empty();

        for (User user : userList){
            if(user.getId() == id){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public User addUser(User user){
        userList.add(user);
        return userList.get(userList.size() - 1);
    }

    public User updateUser(User user, int id){

        Optional<User> findUser = getUser(id);
        User userFound = findUser.orElse(null);

        if(user.getName() != null){
            userFound.setName(user.getName());
        }
        if(user.getAge() != 0){
            userFound.setAge(user.getAge());
        }

        return userFound;

    }

    public void deleteUser(int id){
        for (User user : userList){
            if(user.getId() == id){
                userList.remove(user);
                return;
            }
        }
    } 
}
