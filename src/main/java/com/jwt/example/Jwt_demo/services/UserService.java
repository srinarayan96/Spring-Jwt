package com.jwt.example.Jwt_demo.services;

import com.jwt.example.Jwt_demo.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ToString
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("1", "Sri", "sri@gmail.com"));
        users.add(new User("2", "RVD", "rvd@gmail.com"));
        users.add(new User("3", "MSD", "msd@gmail.com"));
        users.add(new User("4", "SRK", "srk@gmail.com"));
    }

    public List<User> getUsers(){
        System.out.println("in service getUser");
        return users;
    }
}
