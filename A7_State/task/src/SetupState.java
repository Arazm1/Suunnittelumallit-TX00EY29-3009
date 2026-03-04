package A7_State.task.src;

import A7_State.task.src.Levels.NoviceState;
import A7_State.task.src.Character;

public class SetupState extends State{

    public SetupState(Character character){
        super(character);
        this.getCharacter().askName();

    }


    public void action(){
        this.getCharacter().setState(new NoviceState(this.getCharacter()));
    }
    
}
