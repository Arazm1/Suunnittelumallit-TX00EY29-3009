package A13_Visitor.task.src;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
