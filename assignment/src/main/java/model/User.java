package model;

import controller.ChatWindowController;

public abstract class User {

    private static int count = 0;
    private int id;
    private String username;

    private Mediator chatController;
    private ChatWindowController chatWindowController;

    public User(String username, Mediator chatController, ChatWindowController chatWindowController){
        this.id = ++count;
        this.username = username;
        this.chatController = chatController;
        this.chatWindowController = chatWindowController;

        chatController.registerUser(this, chatWindowController);

    }

    public String getUsername(){
        return this.username;
    }

    public void send(String message, String receiver){
        System.out.println(this + " sending message to " + receiver);
        chatController.sendMessage(message, receiver, this);
    }

    // Called by the Mediator when a message arrives
    public void receive(String message, String senderUsername) {
        System.out.println(this + " receiving message from " + senderUsername);
        chatWindowController.receiveMessage(message, senderUsername); 
    }

    // Updates the sidebar
    public void updateContactList(String newContact) {
        System.out.println("Updating list with " + newContact);
        chatWindowController.addUserToList(newContact);
    }


   

} 