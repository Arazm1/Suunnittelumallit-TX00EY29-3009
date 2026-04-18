package model;

import controller.ChatWindowController;

public interface Mediator {
    void registerUser(User user, ChatWindowController chatWindowController);
    void sendMessage(String message, String recipientUser, User sender);
    
}
