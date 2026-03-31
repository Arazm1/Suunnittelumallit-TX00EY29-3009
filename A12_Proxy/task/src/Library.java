package A12_Proxy.task.src;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Document> documents;

    public Library(){
        this.documents = new HashMap<>();
    }


    public void addDocumentToLibrary(int ID, LocalDate date, String content, boolean isProtected){
        RealDocument realDocument = new RealDocument(ID, date, content);
        
        if(isProtected){
            DocumentProxy documentProxy = new DocumentProxy(ID, date, realDocument);
            documents.put(ID, documentProxy);
        }
        else{
            documents.put(ID, realDocument);
        }        
    }

    public void removeDocumentFromLibrary(Document document){
        documents.remove(document.getID());
    }

    public Document getDocument(int ID){
        return documents.get(ID);
    }

    /*
    public void addDocumentToLibrary(Document document){
        documents.put(document.getID(), document);
    }

    public void removeDocumentFromLibrary(Document document){
        documents.remove(document.getID());
    }
    */










    
}
