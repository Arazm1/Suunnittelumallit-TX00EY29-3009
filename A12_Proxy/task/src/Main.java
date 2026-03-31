package A12_Proxy.task.src;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        Library library = new Library();
        
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        library.addDocumentToLibrary(1, LocalDate.of(2026, 3, 31), "All Information is Public", false);
        library.addDocumentToLibrary(2, LocalDate.of(2026, 3, 31), "Top Secret", true);
        library.addDocumentToLibrary(3, LocalDate.of(2026, 3, 31), "Classified", true);

        AccessControlService.getInstance().grantPermissionToDocument(user2.getUsername(), 2);
        AccessControlService.getInstance().grantPermissionToDocument(user3.getUsername(), 3);

        //Test public (Document 1)
        Document document1 = library.getDocument(1);
        try{
            document1.getContent(user1);
            document1.getContent(user2);
        }
        catch(AccessDeniedException e){
            e.printStackTrace();
        }

        System.out.println(document1.getID());
        System.out.println(document1.getDate());


        //Test User2 permissions on Document2
        Document document2 = library.getDocument(2);
        try{
            System.out.println(document2.getContent(user2));
        }
        catch(AccessDeniedException e){
            e.printStackTrace();
        }

        //Test User3 permissions on Document2
        try{
            System.out.println(document2.getContent(user3));
        }
        catch(AccessDeniedException e){
            e.printStackTrace();
        }
        
    }
    
}
