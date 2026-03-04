package A7_State.task.src.Levels;

import A7_State.task.src.Character;
import A7_State.task.src.State;
import A7_State.task.src.Activities.TrainingState;

public class NoviceState extends State {

    public NoviceState(Character character){
        super(character);
    }

    public void action(){
        this.getCharacter().printCharacterStats();
        //this.getCharacter().displayCurrentLevel();
        String[] options = {"Train"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1:
                this.getCharacter().setState(new TrainingState(this.getCharacter()));
                break;
        }
    }
    
}
