package View;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ChatMediator;
import model.Chatter;
import model.IMediator;

public class View extends Application {


    @Override
    public void start(Stage stage){
        IMediator iMediator = new ChatMediator();
        new Chatter("Alice", iMediator);
        new Chatter("Ben", iMediator);
        new Chatter("Chuck", iMediator);
    }
}