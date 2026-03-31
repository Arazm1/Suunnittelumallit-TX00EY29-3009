package A12_Proxy.task.src;

import java.time.LocalDate;

public interface Document {
    int getID();
    LocalDate getDate();
    String getContent(User user) throws AccessDeniedException;

    
    
}
