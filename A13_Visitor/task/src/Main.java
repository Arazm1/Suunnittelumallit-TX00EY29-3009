package A13_Visitor.task.src;

public class Main {
    public static void main(String[] args) {
        
        Directory directory1 = new Directory("Directory1");
        Directory directory2 = new Directory("Directory2");
        Directory directory3 = new Directory("Directory3");

        File file1 = new File("notes.txt", 2.5);
        File file2 = new File("passwords.txt", 2.0);
        File file3 = new File("classDiagram.png", 7);
        File file4 = new File("sprintReview.pdf", 1.5);
        File file5 = new File("wallpaper.png", 5);

        directory1.add(directory2);
        directory1.add(directory3);

        directory2.add(file3);
        directory2.add(file4);

        directory3.add(file1);
        directory3.add(file2);
        directory3.add(file5);


        //SizeCalculator
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        directory1.accept(sizeCalculatorVisitor);


        //SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        directory1.accept(searchVisitor);
        System.out.println("Total found files: " + searchVisitor.getMatchingFiles().size());


    }
    
}
