package model;

import java.util.HashMap;
import java.util.Map;

import controller.ChatWindowController;

public class ChatController implements Mediator{

    private Map<User, ChatWindowController> chatters;

    public ChatController(){
        this.chatters = new HashMap<>();
    }

    public void registerUser(User user, ChatWindowController controller){
        String newUsername = user.getUsername();
        //User newUser = new Chatter(newUsername, this, controller);

        for(User existingUser : chatters.keySet()){
            controller.addUserToList(existingUser.getUsername());
        }

        for(ChatWindowController existingController : chatters.values()){
            existingController.addUserToList(newUsername);
        }
        chatters.put(user, controller);
    }

    @Override
    public void sendMessage(String message, String recipientUser, User sender) {
        ChatWindowController recipientController = null;

        // Find the controller belonging to the recipient
        for (Map.Entry<User, ChatWindowController> entry : chatters.entrySet()) {
            if (entry.getKey().getUsername().equals(recipientUser)) {
                recipientController = entry.getValue();
                break;
            }
        }

        if (recipientController != null) {
            recipientController.receiveMessage(message, sender.getUsername());
        } else {
            System.out.println("Message failed: User " + recipientUser + " not found.");
        }
    }
}
