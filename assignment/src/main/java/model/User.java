package model;

public abstract class User {

    private static int count = 0;
    private int id;
    private String username;

    private IMediator iMediator;

    public User(String username, IMediator iMediator){
        this.id = ++count;
        this.username = username;
        this.iMediator = iMediator;
        //iMediator.registerUser(this);
    }

    public String getUsername(){
        return this.username;
    }

    public void register(){
        iMediator.registerUser(this);
    }

    public void send(String message, String receiver){
        System.out.println(this + " sending message to " + receiver);
        iMediator.sendMessage(message, receiver, this);
    }

    // Called by the Mediator when a message arrives
    public abstract void receive(String message, String senderUsername);
    public abstract void onUserJoined(String newUsername);


} 