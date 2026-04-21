package A18_Prototype.task.src;

public class Book extends Item implements Cloneable{
    private static int idCounter = 0;
    private int id;
    

    public Book(String author, String title, Genre genre){
        super(author, title, genre);
        this.id = ++idCounter;
    }

    @Override
    public Book clone(){
        Book clonedBook = (Book) super.clone();
        clonedBook.id = ++idCounter;
        return clonedBook;
    }

    @Override
    public String toString(){
        return super.toString() + " with ID " + id;
    }

}