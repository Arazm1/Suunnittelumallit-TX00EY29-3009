package A18_Prototype.task.src;

public class RecommendationBuilder {
    private Recommendation recommendation;

    public RecommendationBuilder(){
        reset();
    }

    public void reset(){
        recommendation = new Recommendation();
    }

    public void setAudience(String audience){
        recommendation.setTargetAudience(audience);
    }

    public void addBook(String author, String title, Genre genre){
        recommendation.addItem(new Book(author, title, genre));
    }

    public Recommendation getResult(){
        Recommendation builtRecommendation = recommendation;
        reset();
        return builtRecommendation;
    }
    
}
