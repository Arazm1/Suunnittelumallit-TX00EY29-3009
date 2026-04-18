package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Mediator;
import model.User;

public class ChatWindowController {

    //private Mediator mediator;
    //private String username;
    private User myUser;

    @FXML
    private ListView<String> userList;

    @FXML
    private TextArea messageHistory;

    @FXML
    private TextField messageField;

    /*
    public String getUsername(){
        return this.username;
    }
    */

    public void setUser(User user){
        this.myUser = user;
    }
    

    public void addUserToList(String newUsername){
        userList.getItems().add(newUsername);
    }

    @FXML
    private void handleSend() {
        String message = messageField.getText();
        String recipient = userList.getSelectionModel().getSelectedItem();

        if (message != null && !message.trim().isEmpty() && recipient != null) {
            messageHistory.appendText("You -> " + recipient + ": " + message + "\n");
            
            // Pass the action to the User model!
            myUser.send(message, recipient); 
            
            messageField.clear();
        }
    }

    /* 
    @FXML
    private void handleSend(){
        String message = messageField.getText();
        String recipient = userList.getSelectionModel().getSelectedItem();

        if(message != null && !message.trim().isEmpty() && recipient != null){

            messageHistory.appendText("You -> " + recipient + ": " + message);

            mediator.sendMessage(message, recipient, this.username);
            messageField.clear();
        }
        else{
            System.out.println("Error in handleSend");
        }
    }
        */

    public void receiveMessage(String message, String senderUsername){
       messageHistory.appendText(senderUsername + ": " + message + "\n"); 
    }
    
}
