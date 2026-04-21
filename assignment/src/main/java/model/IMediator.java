package model;

public interface IMediator {
    void registerUser(User user);
    void sendMessage(String message, String recipientUser, User sender);
    
}
