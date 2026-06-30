package com.khushal;

import java.util.List;

public class UserService {
//    private List<String> userNames;
//    public UserService(List<String> userNames) {
//        this.userNames = userNames;
//    }
//    public List<String> getUserNames() {
//        return userNames;
//    }

    public UserService(){
        System.out.println("UserService Created");
    }

    public void init(){
        System.out.println("Post Contruct Phase");
    }
    public void cleanup(){
        System.out.println("Pre Destroy Phase");
    }
}
