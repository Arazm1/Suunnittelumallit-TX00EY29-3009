package A7_State.task.src.Levels;


import A7_State.task.src.Character;
import A7_State.task.src.State;
import A7_State.task.src.Activities.MeditateState;
import A7_State.task.src.Activities.TrainingState;


public class IntermediateState extends State {

    public IntermediateState(Character character){
        super(character);
    }

    public void action(){
        String[] options = {"Train", "Meditate"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1:
                this.getCharacter().setState(new TrainingState(this.getCharacter()));
                break;
            case 2:
                this.getCharacter().setState(new MeditateState(this.getCharacter()));
                break;
        }
    }
}
  
