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

        String[] options = {"Goblin King (Easy)", "Shadow Assassin (Medium)", "Ancient Dragon (Hard)"};
        switch(this.getCharacter().readUserChoice(options)){
            //case 1 -> bossFight();
            case 1 -> fightGoblin();
            case 2 -> fightAssasin();
            case 3 -> fightDragon();
        }

        this.getCharacter().checkLevelUp();
    }


    private void fightGoblin(){
        System.out.println("You challenged the Goblin King!");

         //80% win chance
        if(Math.random() < 0.8){
            System.out.println("You defeated the Goblin King!");
            this.getCharacter().addXPPoints(40);
            this.getCharacter().addHealthPoints(-10);
        } else {
            System.out.println("The Goblin King wounded you!");
            this.getCharacter().addHealthPoints(-25);
        }

    }

    private void fightAssasin(){
        System.out.println("You challenged the Shadow Assassin");

        //60% win chance
        if(Math.random() < 0.6){
            System.out.println("You defeated the Shadow Assassin!");
            this.getCharacter().addXPPoints(60);
            this.getCharacter().addHealthPoints(-15);
        } else {
            System.out.println("The Shadow Assassin wounded you!");
            this.getCharacter().addHealthPoints(-30);
        }
    }

    private void fightDragon(){
        System.out.println("You challenged the Ancient Dragon");

        //40% win chance
        if(Math.random() < 0.4){
            System.out.println("You defeated the Ancient Dragon!");
            this.getCharacter().addXPPoints(80);
            this.getCharacter().addHealthPoints(-20);
        } else {
            System.out.println("The Ancient Dragon wounded you!");
            this.getCharacter().addHealthPoints(-40);
        }
    }
    
}
