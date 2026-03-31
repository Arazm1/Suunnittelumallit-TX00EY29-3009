package A12_Proxy.task.src;

import java.time.LocalDate;

public class DocumentProxy implements Document {

    private int ID;
    private LocalDate date;
    private RealDocument realDocument;

    public DocumentProxy(int ID, LocalDate date, RealDocument realDocument){
        this.ID = ID;
        this.date = date;
        this.realDocument = realDocument;
    }

    @Override
    public int getID(){
        return this.ID;
    }

    @Override
    public LocalDate getDate(){
        return this.date;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException{
        if(realDocument != null){
            System.out.println("*** Checking permissions for User: " + user.getID());
            boolean allowed = AccessControlService.getInstance().isAllowed(user.getUsername(), this.ID);
        
            if(allowed){
                System.out.println("Authorized..");
                return "Content of Document " + this.ID + ": " + realDocument.getContent(user) + "\n";
            }
            else{
                throw new AccessDeniedException("Access denied for User: " + user.getID() + " to view the Document " + this.ID);
            }
        }
        else{
            return "No Document found!";
        }     
    }
    
}
