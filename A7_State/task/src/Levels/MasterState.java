package A7_State.task.src.Levels;

import A7_State.task.src.State;
import A7_State.task.src.Character;

public class MasterState extends State{

    public MasterState(Character character){
        super(character);
    }

    @Override
    public void action(){
        //this.getCharacter().displayCurrentLevel();
        this.getCharacter().printCharacterStats();
        System.out.println("The WORK is done.");
        return;
    }
    
}
