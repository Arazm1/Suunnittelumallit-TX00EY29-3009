package A10_Chain_of_Responsibility.task.src;

import A10_Chain_of_Responsibility.task.src.Message.MessageType;

public class HandleContactRequest extends Handler{

    private static final MessageType messageType =  MessageType.CONTACT_REQUEST;

    @Override
    public void processFeedback(Message message){

        //MessageType is Contact_Request + Sender and Content included
        if(message.getMessageType() == messageType && !message.getSenderEmail().trim().isEmpty() && !message.getMessageContent().trim().isEmpty()){
            System.out.println("Contact Request is being sent..\n");

            System.out.println("Information");
            System.out.println("Sender: " + message.getSenderEmail());
            System.out.println("Content: " + message.getMessageContent());

            try{
                Thread.sleep(2000);
            }
            catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("Contact Request sent successfully!");

        }
        //Not a Contact Request => Development Suggestion
        else{
            super.processFeedback(message);
        }
    }
}
