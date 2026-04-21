package A18_Prototype.task.src;

public class Director {

    public void makeEmptyList(RecommendationBuilder builder) {
        builder.reset();
        builder.setAudience("None");
    }

    
    public void makeBasicFantasyList(RecommendationBuilder builder) {
        builder.reset();
        builder.setAudience("Basic Fantasy Fans");
        builder.addBook("J.R.R. Tolkien", "The Fellowship of the Ring", Genre.FANTASY);
        builder.addBook("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", Genre.FANTASY);
    }

    public void makeBasicSciFiList(RecommendationBuilder builder) {
        builder.reset();
        builder.setAudience("Basic Sci-Fi Fans");
        builder.addBook("Frank Herbert", "Dune", Genre.SCIENCE_FICTION);
        builder.addBook("Orson Scott Card", "Ender's Game", Genre.SCIENCE_FICTION);
    }

    public void makeBasicHistoricalList(RecommendationBuilder builder) {
        builder.reset();
        builder.setAudience("Historical Fiction Buffs");
        builder.addBook("Markus Zusak", "The Book Thief", Genre.HISTORICAL);
        builder.addBook("Ken Follett", "The Pillars of the Earth", Genre.HISTORICAL);
    }

    public void makeBasicMysteryList(RecommendationBuilder builder) {
        builder.reset();
        builder.setAudience("Mystery Solvers");
        builder.addBook("Agatha Christie", "And Then There Were None", Genre.MYSTERY);
        builder.addBook("Arthur Conan Doyle", "The Hound of the Baskervilles", Genre.MYSTERY);
    }

    public void makeBasicFictionList(RecommendationBuilder builder) {
        builder.reset();
        builder.setAudience("General Fiction Readers");
        builder.addBook("Harper Lee", "To Kill a Mockingbird", Genre.FICTION);
        builder.addBook("F. Scott Fitzgerald", "The Great Gatsby", Genre.FICTION);
    }
    
}
