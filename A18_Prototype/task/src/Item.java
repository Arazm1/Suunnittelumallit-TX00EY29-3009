package A18_Prototype.task.src;

public abstract class Item implements Cloneable{
    private String author;
    private String title;
    private Genre genre;

    public Item(String author, String title, Genre genre){
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public Item clone(){
        try{
            return (Item) super.clone();

        }
        catch(CloneNotSupportedException e){
            throw new RuntimeException("This should not happen since we implement Cloneable", e);
        }
    }

    @Override
    public String toString(){
        return this.title + " by " + this.author + " (" + this.genre + ")";

    }
}