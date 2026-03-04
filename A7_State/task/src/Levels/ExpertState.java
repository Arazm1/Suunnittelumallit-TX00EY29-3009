package A7_State.task.src.Levels;

import A7_State.task.src.Character;
import A7_State.task.src.State;
import A7_State.task.src.Activities.FightState;
import A7_State.task.src.Activities.MeditateState;
import A7_State.task.src.Activities.TrainingState;

public class ExpertState extends State {

    public ExpertState(Character character){
        super(character);
    }

    public void action(){
        //this.getCharacter().displayCurrentLevel();
        this.getCharacter().printCharacterStats();
        String[] options = {"Train", "Meditate", "Fight"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1:
                this.getCharacter().setState(new TrainingState(this.getCharacter()));
                break;
            case 2:
                this.getCharacter().setState(new MeditateState(this.getCharacter()));
                break;
            case 3:
                this.getCharacter().setState(new FightState(this.getCharacter()));
                break;
        }

        
    }
}
