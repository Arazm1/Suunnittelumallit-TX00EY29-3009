package View;

import controller.ChatWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ChatController;
import model.Chatter;
import model.Mediator;
import model.User;

public class View extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Create the SINGLE central Mediator
        Mediator centralMediator = new ChatController();

        // 2. Spawn 3 distinct clients
        createClientWindow("Alice", centralMediator);
        createClientWindow("Bob", centralMediator);
        createClientWindow("Charlie", centralMediator);
    }

    private void createClientWindow(String username, Mediator mediator) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chat_window.fxml"));
        Parent root = loader.load();

        // Get the UI Controller that FXML just created
        ChatWindowController uiController = loader.getController();

        // Create the logical User, passing it the Mediator and the UI Controller
        // (This constructor automatically registers everything!)
        User user = new Chatter(username, mediator, uiController);

        // Tell the UI Controller who its User is
        uiController.setUser(user);

        // Set up the JavaFX Window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Chat - " + username); // Assignment requirement: Unique Title!
        stage.show();
    }
}