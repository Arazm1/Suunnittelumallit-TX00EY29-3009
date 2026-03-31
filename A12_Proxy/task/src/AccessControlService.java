package A12_Proxy.task.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<String, Set<Integer>> permissions;

    private AccessControlService(){
        this.permissions = new HashMap<>();
    }

    public static synchronized AccessControlService getInstance(){
        if(instance == null){
            instance = new AccessControlService();
        }
        return instance;
    }

    /**
     * Grant permissions to user
     * @param username of the User
     * @param documentID of the Document
     */
    public synchronized void grantPermissionToDocument(String username, int documentID){
        Set<Integer> docs = permissions.getOrDefault(username, new TreeSet<>());
        docs.add(documentID);
        permissions.put(username, docs);
    }

    /**
     * Get the set of documents a user can access
     * @param username of the User
     * @param documentID of the Document
     * @return true if user has permissions to view the Document.
     */
    public synchronized boolean isAllowed(String username, int documentID){
        Set<Integer> docs = permissions.getOrDefault(username, new TreeSet<>());
        return docs.contains(documentID);
    }
    
}
