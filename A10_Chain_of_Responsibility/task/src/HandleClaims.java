package A10_Chain_of_Responsibility.task.src;

import java.util.Random;

import A10_Chain_of_Responsibility.task.src.Message.MessageType;

public class HandleClaims extends Handler{

    private static final MessageType messageType = MessageType.CLAIMS;
    private final Random random = new Random();

    @Override
    public void processFeedback(Message message){

        //MessageType is Claim and there is Email + Content
        if(message.getMessageType() == messageType && !message.getSenderEmail().trim().isEmpty() && !message.getMessageContent().trim().isEmpty()){
            System.out.println("Claim is being reviewed..\n");

            System.out.println("Information");
            System.out.println("Sender: " + message.getSenderEmail());
            System.out.println("Content: " + message.getMessageContent());

            boolean approved = Math.random() > 0.5;
            if(approved){
                System.out.println("The claim was approved!");
            }
            else{
                System.out.println("The claim was denied!");
            }
        }
        //Not a Claim => Contact Request
        else{
            super.processFeedback(message);
        }
    }
    
}
