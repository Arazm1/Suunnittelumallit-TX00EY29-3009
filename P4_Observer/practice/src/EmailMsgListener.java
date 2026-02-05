public class EmailMsgListener implements Observer {
    private final String email;

    public EmailMsgListener(String email){
        this.email = email;
    }

    @Override
    public void update(String message){
        System.out.println("Sending email to " + this.email + ": " + message);
    }
    
}
