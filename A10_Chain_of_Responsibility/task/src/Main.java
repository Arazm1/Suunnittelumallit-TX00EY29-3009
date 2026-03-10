package A10_Chain_of_Responsibility.task.src;

import A10_Chain_of_Responsibility.task.src.Message.MessageType;

public class Main {

    public static void main(String[] args) {
        
        Handler primaryHandler;

        Handler handleClaims = new HandleClaims();
        Handler handleContactRequest = new HandleContactRequest();
        Handler handleDevelopmentSuggestion = new HandleDevelopmentSuggestion();
        Handler handleGeneralFeedback = new HandleGeneralFeedback();

        handleClaims.setNextHandler(handleContactRequest);
        handleContactRequest.setNextHandler(handleDevelopmentSuggestion);
        handleDevelopmentSuggestion.setNextHandler(handleGeneralFeedback);
        primaryHandler = handleClaims;

        Message message = new Message(MessageType.GENERAL_FEEDBACK, "Java is good", "def@Spam.not");
        primaryHandler.processFeedback(message);
    }
    
}
