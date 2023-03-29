package service;

import model.Event;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, Integer> userEmailUserIdMap;
    private Map<String, User> emailUserMap;

    public UserService() {
        userEmailUserIdMap = new HashMap<>();
        emailUserMap = new HashMap<>();

    }

    public User createUser(String name, String email){
        if(!emailUserMap.containsKey(email)){
            User user = new User(name, email);
            emailUserMap.put(email, user);
            userEmailUserIdMap.put(email, user.getId());
        }
        return emailUserMap.get(email);
    }
}
