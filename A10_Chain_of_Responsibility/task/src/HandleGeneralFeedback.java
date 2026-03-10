package A10_Chain_of_Responsibility.task.src;

import java.util.Random;


public class HandleGeneralFeedback extends Handler {

    private final Random random = new Random();

    @Override
    public void processFeedback(Message message){
        if(!message.getSenderEmail().trim().isEmpty() && !message.getMessageContent().trim().isEmpty()){
            System.out.println("Your feedback is being sent..");

            System.out.println("Information");
            System.out.println("Sender: " + message.getSenderEmail());
            System.out.println("Content: " + message.getMessageContent());

            boolean isTakenIntoConsideration = Math.random() < 0.001;
            int never = 500 + (int)(Math.random() * 501);
            if(isTakenIntoConsideration){
                System.out.println("The Feedback was sent to our team. We will be in contact within 24 hours");
            }
            else{
                System.out.println("Thank you for your Feedback. We appreciate all the Feedback we get");
                System.out.println("We will be reviewing it and be in contact within " + never + " hours.");
            }
        }
        else{
            System.out.println("System down. Sorry.");
        }
    }
}