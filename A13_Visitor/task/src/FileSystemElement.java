package A13_Visitor.task.src;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
