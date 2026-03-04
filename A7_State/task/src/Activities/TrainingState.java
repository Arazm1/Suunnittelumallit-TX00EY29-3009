package A7_State.task.src.Activities;

import A7_State.task.src.State;

import java.util.Random;

import A7_State.task.src.Character;

public class TrainingState extends State {

    private final Random random = new Random();

    public TrainingState(Character character){
        super(character);
    }

    @Override
    public void action(){

        getCharacter().printCharacterStats();

        String[] options = {"Strength Training", "Endurance Training", "Intense Training"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1 -> strengthTraining();
            case 2 -> enduranceTraining();
            case 3 -> intenseTraining();
        }

    }


    //Todo: Randomize points
    private void strengthTraining(){
        this.getCharacter().addXPPoints(random.nextInt(5) + 8);
        this.getCharacter().addHealthPoints(-(random.nextInt(4) + 3));
    }

    private void enduranceTraining(){
        this.getCharacter().addXPPoints(random.nextInt(6) + 12);
        this.getCharacter().addHealthPoints(-(random.nextInt(4) + 4));
    }

    private void intenseTraining(){
        this.getCharacter().addXPPoints(random.nextInt(8) + 18);
        this.getCharacter().addHealthPoints(-(random.nextInt(6) + 5));
    }
    
}
