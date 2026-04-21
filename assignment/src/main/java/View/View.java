package View;

import controller.ChatController;
import controller.IMediator;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Chatter;

public class View extends Application {


    @Override
    public void start(Stage stage){
        IMediator iMediator = new ChatController();
        new Chatter("Alice", iMediator);
        new Chatter("Ben", iMediator);
        new Chatter("Chuck", iMediator);
    }
    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Create the SINGLE central Mediator
        IMediator centralMediator = new ChatController();

        // 2. Spawn 3 distinct clients
        createClientWindow("Alice", centralMediator);
        createClientWindow("Bob", centralMediator);
        createClientWindow("Charlie", centralMediator);
    }

    private void createClientWindow(String username, IMediator mediator) throws Exception {
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
    */
}