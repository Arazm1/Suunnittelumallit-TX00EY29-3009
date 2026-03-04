package A7_State.task.src.Activities;

import A7_State.task.src.State;
import A7_State.task.src.Character;

public class MeditateState extends State{

    public MeditateState(Character character){
        super(character);
    }

    @Override
    public void action(){

        //getCharacter().printCharacterStats();
        //this.getCharacter().displayCurrentLevel();
        String[] options = {"Meditate"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1 -> meditate();
        }

        this.getCharacter().checkLevelUp();

    }


    private void meditate(){
        int gainedHealthPoints =(int)(Math.random() * 21) + 10;
        this.getCharacter().addHealthPoints(gainedHealthPoints);
        System.out.println("Gained HealthPoints: " + gainedHealthPoints );
    }
}