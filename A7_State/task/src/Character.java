package A7_State.task.src;

import java.util.Random;
import java.util.Scanner;

import A7_State.task.src.Levels.IntermediateState;
import A7_State.task.src.Levels.ExpertState;
import A7_State.task.src.Levels.NoviceState;
import A7_State.task.src.Levels.MasterState;


public class Character {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private final String defaultNames[] = {"John", "Steve", "Alex", "Jane"};
    private State state;

    //Character attributes
    private String name;
    private levelType level;
    private double xpPoints;
    private double healthPoints;

    public enum levelType{
        Novice,
        Intermediate,
        Expert,
        Master
    }


    public Character(){
        state = new SetupState(this);
        //Init values
        setLevel(levelType.Novice);
        setXPPoints(0);
        setHealthPoints(100);
    }

    public void operate(){
        while(true){
            if(this.state == null){
                System.out.println("Character dead..too bad");
                return;
            }

            state.action();
        }
    }

    public void setState(State state){
        this.state = state;
    }


    public int readUserChoice(String[] options){
        System.out.println("\nSelect an option: ");
        for(int i=1; i<=options.length; i++){
            System.out.println(i + ". " + options[i-1]);
        }

        return scanner.nextInt();
    }



    //Character
    public void askName(){
        System.out.println("Enter a username or computer will pick a default name for you: ");
        String name = scanner.nextLine();
        if(name.trim().isEmpty()){
            name = defaultNames[random.nextInt(defaultNames.length)];
        }
        setName(name);
        System.out.println(name + " chosen as the name of the character.");
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(levelType level){
        this.level = level;
    }

    public void setXPPoints(double xpPoints){
        this.xpPoints = xpPoints;
    }

    public void setHealthPoints(double healthPoints){
        this.healthPoints = healthPoints;
    }


    public String getName(){
        return this.name;
    }

    public levelType getLevel(){
        return this.level;
    }

    public double getXPPoints(){
        return this.xpPoints;
    }

    public double getHealthPoints(){
        return this.healthPoints;
    }


    public void addXPPoints(double xpPoints){
        this.xpPoints += xpPoints;
    }

    public void addHealthPoints(double healthPoints){
        this.healthPoints += healthPoints;
    }

    public void checkLevelUp(){
        //Level-Up check
        if(getXPPoints() >= 300){
            System.out.println("You have leveled up to Master Level!");
            setLevel(Character.levelType.Master);
            setState(new MasterState(this));
        }
        else if(getXPPoints() >= 200){
            System.out.println("You have leveled up to Expert Level!");
            setLevel(Character.levelType.Expert);
            setState(new ExpertState(this));
        }
        else if(getXPPoints() >= 100){
            System.out.println("You have leveled up to Intermediate Level!");
            setLevel(Character.levelType.Master);
            setState(new IntermediateState(this));
        }
        else{
            setState(new NoviceState(this));
        }

    }

    public void printCharacterStats(){
        System.out.println("Current character stats:");
        System.out.println("------------------------:");
        System.out.println("Character name: " + getName());
        System.out.println("Character Level: " + getLevel());
        System.out.println("Character XP Points: " + getXPPoints());
        System.out.println("Character Healthpoints: " + getHealthPoints());
        System.out.println("------------------------:");
    }
}