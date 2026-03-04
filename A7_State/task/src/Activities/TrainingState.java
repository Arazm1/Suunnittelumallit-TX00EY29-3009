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

        //this.getCharacter().displayCurrentLevel();
        displayWelcomeMSG();

        String[] options = {"Strength Training", "Endurance Training", "Intense Training"};
        switch(this.getCharacter().readUserChoice(options)){
            case 1 -> strengthTraining();
            case 2 -> enduranceTraining();
            case 3 -> intenseTraining();
        }

        this.getCharacter().checkLevelUp();

    }


    //Todo: Randomize points
    private void strengthTraining(){
        int gainedXPPoints = random.nextInt(5) + 8;
        int lostHealthPoints = random.nextInt(4) + 3;

        this.getCharacter().addXPPoints(gainedXPPoints);
        this.getCharacter().addHealthPoints(-(lostHealthPoints));

        displayProgress(gainedXPPoints, lostHealthPoints);
    }

    private void enduranceTraining(){
        int gainedXPPoints = random.nextInt(6) + 12;
        int lostHealthPoints = random.nextInt(4) + 4;

        this.getCharacter().addXPPoints(gainedXPPoints);
        this.getCharacter().addHealthPoints(-(lostHealthPoints));

        displayProgress(gainedXPPoints, lostHealthPoints);
    }

    private void intenseTraining(){
        int gainedXPPoints = random.nextInt(8) + 18;
        int lostHealthPoints = random.nextInt(6) + 5;

        this.getCharacter().addXPPoints(gainedXPPoints);
        this.getCharacter().addHealthPoints(-(lostHealthPoints));

        displayProgress(gainedXPPoints, lostHealthPoints);
    }

    private void displayWelcomeMSG(){
        System.out.println();
        System.out.println("----------------");
        System.out.println("Training Session");
        System.out.println("----------------");
    }

    /**
     * Displays the result of Training
     * @param gainedXPPoints points of XP gained from the Training session.
     * @param lostHealthPoints points of HP losts due to the Training session.
     */
    private void displayProgress(int gainedXPPoints, int lostHealthPoints){
        System.out.println("Gained XP points: " + gainedXPPoints);
        System.out.println("Lost Health Points: " + lostHealthPoints + "\n");
    }
}
