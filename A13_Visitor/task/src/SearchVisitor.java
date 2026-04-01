package A13_Visitor.task.src;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor{
    
    private String filename;
    private List<File> matchingFiles = new ArrayList<>();
    

    public SearchVisitor(String filename){
        this.filename = filename;
    }

    @Override
    public void visit(File file){
        if(file.getName().contains(filename)){
            matchingFiles.add(file);
            System.out.println("File found: " + file.getName());
        }
        else{
            System.out.println("File not found");
        }
    }

    public void visit(Directory directory){
        System.out.println("Searching in directory: " + directory.getName());
    }

    public List<File> getMatchingFiles(){
        return this.matchingFiles;
    }
}
