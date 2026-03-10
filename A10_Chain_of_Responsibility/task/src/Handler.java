package A10_Chain_of_Responsibility.task.src;

public abstract class Handler {

    private Handler nextHandler;

    public void processFeedback(Message message){
        if(nextHandler != null){
            nextHandler.processFeedback(message);
        }
    }

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    
    }   
}