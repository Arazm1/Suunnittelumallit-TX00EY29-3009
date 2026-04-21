package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Chatter;

public class ChatWindowController {

    private Chatter chatter;

    @FXML
    private ListView<String> userList;

    @FXML
    private TextArea messageHistory;

    @FXML
    private TextField messageField;


    public void setChatter(Chatter chatter){
        this.chatter = chatter;
    }

    public Chatter getChatter(){
        return this.chatter;
    }
    

    public void addUserToList(String username){
        userList.getItems().add(username);
    }

    public void displayMessage(String formattedMessage) {
        messageHistory.appendText(formattedMessage + "\n");
    }

    @FXML
    private void handleSend() {
        String message = messageField.getText();
        String recipient = userList.getSelectionModel().getSelectedItem();

        if(message.isEmpty() || recipient == null){
            System.out.println("handleSend failed!");
            return;
        }

        messageHistory.appendText("You -> " + recipient + ": " + message + "\n");
        chatter.send(message, recipient);
        messageField.clear();
    }

    //public void receiveMessage(String message, String senderUsername){
    //   messageHistory.appendText(senderUsername + ": " + message + "\n"); 
    //}
    
}
