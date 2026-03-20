import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private GUI gui;
    private List<IMemento> history; //Memento history
    private List<IMemento> redoHistory;


    public Controller(GUI gui){
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice){
        saveToHistory();
        model.setOption(optionNumber, choice);
        clearRedoHistory();
    }

    public int getOption(int optionNumber){
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected){
        saveToHistory();
        model.setIsSelected(isSelected);
        clearRedoHistory();
    }

    public boolean getIsSelected(){
        return model.getIsSelected();
    }


    public void undo(){
        if(!history.isEmpty()){
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            saveToRedoHistory();
            model.restoreState(previousState);
            gui.updateGui();
            
        }
    }

    public void redo(){
        if(!redoHistory.isEmpty()){
        System.out.println("Redo! Memento found in redoHistory");
        IMemento state = redoHistory.remove(redoHistory.size() -1);
        saveToHistory();
        model.restoreState(state);
        gui.updateGui();
        }
    }

    private void saveToHistory(){
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }
    
    private void saveToRedoHistory(){
        IMemento currentState = model.createMemento();
        redoHistory.add(currentState);
    }

    public void restoreState(IMemento state){
        //history.add(state);
        //clearRedoHistory();
        model.restoreState(state);
        gui.updateGui();
    }

    public List<IMemento> getHistory(){
        return this.history;
    }

    /**
     * Clears the 'RedoHistory' ArrayList
     * Meant to be called whenever user clicks a Box/checkbox
     */
    private void clearRedoHistory(){
        this.redoHistory.clear();
    }
}