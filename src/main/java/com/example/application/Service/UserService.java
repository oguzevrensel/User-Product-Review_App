package com.example.application.Service;

import org.springframework.stereotype.Service;
import com.example.application.Entity.User;
import com.example.application.Repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public List<User> findAllProductReview(int id){
        return this.findAllProductReview(id);
    }

    public List<User> add(User user){
        if(user.getFirstName().isEmpty() || user.getFirstName().isBlank()
                || user.getLastName().isEmpty() || user.getLastName().isBlank()
                || user.getEmail().isEmpty() || user.getEmail().isBlank()
                || user.getPhoneNumber()<=14)
            return null;

        this.userRepository.save(user);
        return null;
    }


}
