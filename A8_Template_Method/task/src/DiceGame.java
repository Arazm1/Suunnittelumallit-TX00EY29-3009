package A8_Template_Method.task.src;

public class DiceGame extends Game{

    private int[] scores;
    private int numberOfPlayers;

    @Override
    public void initializeGame(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];
        //System.out.println(scores);
    }

    @Override
    public boolean endOfGame(){
        for(int i = 0; i< numberOfPlayers; i++){
            if(scores[i] >= 50){
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player){
        int roll = (int)(Math.random() * 6) + 1;
        scores[player] += roll;
        System.out.println("Player: " + player + " rolled " + roll);
        System.out.println("Player: " + player + " total score " + scores[player]);
        System.out.println("---------------------------");
    }

    @Override
    public void displayWinner(){
        for(int i = 0; i<numberOfPlayers; i++){
            if(scores[i] >= 50){
                System.out.println("Player " + i + " won!");
            }
        }
    }
}
