import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class HistoryWindow extends Stage{

    private ObservableList<IMemento> pastHistory;
    private ListView<IMemento> listView;
    //private List<IMemento> redoHistory;

    public HistoryWindow(List<IMemento> pastHistory, Controller controller){
        this.pastHistory = FXCollections.observableArrayList(pastHistory);
        //this.redoHistory = new ArrayList<>(futureHistory);
        listView = new ListView<>(this.pastHistory);


        listView.setOnMouseClicked(event -> {
            IMemento selected = listView.getSelectionModel().getSelectedItem();
            if(selected != null){
                controller.restoreState(selected);
            }
        });

        Scene scene = new Scene(listView);
        setScene(scene);
        setTitle("History");

    }


    
    
}
