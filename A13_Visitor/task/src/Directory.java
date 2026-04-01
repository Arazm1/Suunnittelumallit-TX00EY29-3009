package A13_Visitor.task.src;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement{
    private String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<FileSystemElement> getChildren(){
        return this.children;
    }

    public void add(FileSystemElement fileSystemElement){
        this.children.add(fileSystemElement);
    }

    @Override
    public void accept(FileSystemVisitor visitor){
        visitor.visit(this);
        for(FileSystemElement child : children){
            child.accept(visitor);
        }

    }
    
}
