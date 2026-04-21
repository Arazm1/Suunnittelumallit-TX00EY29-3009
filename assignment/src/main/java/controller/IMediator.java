package controller;

import model.User;

public interface IMediator {
    void registerUser(User user);
    void sendMessage(String message, String recipientUser, User sender);
    
}
