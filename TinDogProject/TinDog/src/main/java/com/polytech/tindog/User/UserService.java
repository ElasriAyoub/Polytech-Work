package com.polytech.tindog.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean emailExists(String email){
        if(userRepository.findByEmail(email).isPresent())
            return true;
        return false;
    }

    public UUID createUser(String email, String password) throws Exception{

        if(emailExists(email))
            throw new Exception(("A user using this e-mail already exists."));
        else{
            User user = new User(UUID.randomUUID(),email, password, UUID.randomUUID().toString(),"USER");
            userRepository.save(user);
            System.out.println(UUID.fromString(user.getOwnerId()));
            return UUID.fromString(user.getOwnerId());
        }
    }

    public UUID login(String email, String password) throws Exception{
        if(emailExists(email)){
            Optional<User> user = userRepository.findByEmail(email);
            String userPassword = user.get().getPassword();
            if(password.equals(userPassword)){
                return UUID.fromString(user.get().getOwnerId());
            }
            else
                throw new Exception(("Password is not correct"));
        }
        else
            throw new Exception(("This e-mail doesn't exist."));
    }

    public User getUserById(UUID id) throws Exception {
        if(!userRepository.findById(id).isPresent())
            throw new Exception(("A user with this id doesn't exist"));
        return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) throws Exception {
        if(!emailExists(email)){
            throw new Exception(("This e-mail doesn't exist."));
        }
        return userRepository.findByEmail(email).get();
    }


}
