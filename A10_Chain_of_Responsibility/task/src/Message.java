package A10_Chain_of_Responsibility.task.src;

public class Message {
    
    public enum MessageType{
        CLAIMS,
        CONTACT_REQUEST,
        DEVELOPMENT_SUGGESTION,
        GENERAL_FEEDBACK
    }

    private MessageType messageType;
    private String messageContent;
    private String senderEmail;

    public Message(MessageType messageType, String messageContent, String senderEmail){
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType(){
        return this.messageType;
    }

    public String getMessageContent(){
        return this.messageContent;
    }

    public String getSenderEmail(){
        return this.senderEmail;
    }
}