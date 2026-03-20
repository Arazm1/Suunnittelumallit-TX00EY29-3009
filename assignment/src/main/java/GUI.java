import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application{

    private Controller controller;
    private ColorBox colorBox1; 
    private ColorBox colorBox2; 
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private Button historyButton;


    public void start(Stage stage){
        controller = new Controller(this);

        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        historyButton = new Button("History");
        historyButton.setPadding(insets);



        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo the last change.");
        label.setPadding(insets);

        //Create a VBox that contains the HBox and the Checkbox
        VBox vBox = new VBox(hBox, checkBox, label, historyButton);
        //Call controller when the CheckBox is clicked
        checkBox.setOnAction(event ->{
            controller.setIsSelected(checkBox.isSelected());
        });

        //Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);

        
        scene.setOnKeyPressed(event ->{
            //Ctrl-Z: undo
            if(event.isControlDown() && event.getCode() == KeyCode.Z){
                System.out.println("Undo key combination pressed");
                controller.undo();
            }

            //Ctrl-Y: redo
            if(event.isControlDown() && event.getCode() == KeyCode.Y){
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        historyButton.setOnAction(event -> {
            System.out.println("History button clicked!");
            HistoryWindow historyWindow = new HistoryWindow(controller.getHistory(), controller);
            historyWindow.show();
        });


        

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui(){
        //Called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
    
}
