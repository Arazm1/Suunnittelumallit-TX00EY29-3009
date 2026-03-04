package A7_State.task.src.Activities;

import A7_State.task.src.State;
import A7_State.task.src.Character;

public class FightState extends State{

    public FightState(Character character){
        super(character);
    }

    @Override
    public void action(){
        //getCharacter().printCharacterStats();
        //this.getCharacter().displayCurrentLevel();

        String[] options = {"Boss fight"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1 -> bossFight();
        }

        this.getCharacter().checkLevelUp();
    }


    private void bossFight(){
        this.getCharacter().addXPPoints(100);
        this.getCharacter().addHealthPoints(100);
    }
    
}
