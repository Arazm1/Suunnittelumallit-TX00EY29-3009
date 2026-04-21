package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

public class ChatController implements IMediator{

    private final List<User> users;

    public ChatController(){
        this.users = new ArrayList<>();
    }

    @Override
    public void registerUser(User newUser){
        
        for(User existingUser : users){
            newUser.onUserJoined(existingUser.getUsername());
        }

        for(User existingUser : users){
            existingUser.onUserJoined(newUser.getUsername());
        }

        users.add(newUser);
    }

    @Override
    public void sendMessage(String message, String recipientUsername, User sender) {

        for(User user : users){
            if(user.getUsername().equals(recipientUsername)){
                user.receive(message, sender.getUsername());
                return;
            }
        }

        System.out.println("User not found: " + recipientUsername);
    }
}
