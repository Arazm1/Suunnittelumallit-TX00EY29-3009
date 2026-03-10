package A10_Chain_of_Responsibility.task.src;

import A10_Chain_of_Responsibility.task.src.Message.MessageType;

public class HandleDevelopmentSuggestion extends Handler{

    private static final MessageType messageType =  MessageType.DEVELOPMENT_SUGGESTION;

    @Override
    public void processFeedback(Message message){

        //MessageType is Development_Suggestion and Content is included
        if(message.getMessageType() == messageType && !message.getMessageContent().trim().isEmpty()){
            System.out.println("Development Suggestion is being sent..\n");

            System.out.println("Information");
            System.out.println("Sender: " + message.getSenderEmail());
            System.out.println("Content: " + message.getMessageContent());

            try{
                Thread.sleep(1000);
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("Development Suggestion sent successfully!");
            try{
                Thread.sleep(1000);
                
            }
            catch(Exception e){
                e.printStackTrace();
            }

            //Email ones get sent
            if(!message.getSenderEmail().trim().isEmpty()){
                boolean appreciated = Math.random() > 0.5;
                if(appreciated){
                    System.out.println("Thank you for the Development Suggestion. We have forwarded it to our Senior Developers!");
                }
                else{
                    System.out.println("Thank you for the Development Suggestion. We'd love to hire your AI!");
                }
            }
            else{
                System.out.println("Unfortunately, due to high traffic your message was unable to be delivered..");
            }
        }
        else{
            super.processFeedback(message);
        }
    }
    
}
