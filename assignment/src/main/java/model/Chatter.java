package model;

import controller.ChatWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chatter extends User{

    private ChatWindowController windowController;

    public Chatter(String username, IMediator iMediator){
        super(username, iMediator);
        loadWindow();

        register();
    }


    private void loadWindow(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chat_window.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            windowController = fxmlLoader.getController();
            windowController.setChatter(this);

            Stage stage = new Stage();
            stage.setTitle("Chat window - " + getUsername());
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void receive(String message, String senderUsername) {
        windowController.displayMessage(senderUsername + ": " + message);
    }

    @Override
    public void onUserJoined(String newUsername) {
        windowController.addUserToList(newUsername);
    }
}