package model;

import controller.ChatWindowController;

public class Chatter extends User{

    public Chatter(String username, Mediator chatController, ChatWindowController chatWindowController){
        super(username, chatController, chatWindowController);
    }
}