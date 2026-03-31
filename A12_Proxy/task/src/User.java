package A12_Proxy.task.src;

public class User {
    private static int userCounter = 0;

    private int userID;
    private String username;

    public User(String username){
        this.username = username;
        userCounter++;
        this.userID = userCounter;
    }

    public int getID(){
        return this.userID;
    }

    public String getUsername(){
        return this.username;
    }

    public static int getTotalUserCount(){
        return userCounter;
    }
    
}