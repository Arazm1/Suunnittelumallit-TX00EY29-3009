package A13_Visitor.task.src;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file){
        totalSize += file.getSize();
        System.out.println("File size: " + file.getSize());

    }

    @Override
    public void visit(Directory directory){
        System.out.println("Directory doesnt have a size");
    }

    public double getTotalSize(){
        return this.totalSize;
    }
}
