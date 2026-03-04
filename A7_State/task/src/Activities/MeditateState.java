package A7_State.task.src.Activities;

import A7_State.task.src.State;
import A7_State.task.src.Character;

public class MeditateState extends State{

    public MeditateState(Character character){
        super(character);
    }

    @Override
    public void action(){

        getCharacter().printCharacterStats();
        String[] options = {"Meditate"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1 -> meditate();
        }

    }


    private void meditate(){
        this.getCharacter().addHealthPoints(10);
    }
    
}
