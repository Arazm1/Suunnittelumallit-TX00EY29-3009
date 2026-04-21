package A18_Prototype.task.src;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private List<Item> items;

    public Recommendation(){
        this.items = new ArrayList<>();
    }

    public void setTargetAudience(String targetAudience){
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience(){
        return this.targetAudience;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public List<Item> getItems(){
        return this.items;
    }

    @Override
    public Recommendation clone(){
        try{
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            clonedRecommendation.items = new ArrayList<>();
            //deep copy
            for(Item item : this.items){
                clonedRecommendation.addItem(item.clone());
            }
            return clonedRecommendation;

        }
        catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    @Override
    public String toString(){
        return "Recommendation list with items \n" + this.items;
    }



    
}
