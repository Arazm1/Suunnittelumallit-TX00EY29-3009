package A9_Strategy.task.src;

import java.util.List;

public class InsertionSortAlgorithm implements AlgorithmStrategy {


    @Override
    public boolean processSorting(List<Integer> numbers){
        System.out.println("Sorting with InsertionSort algorithm..");

        int arrayLength = numbers.size();
        for(int i = 0; i<arrayLength; ++i){

            int key = numbers.get(i);
            int j = i -1;

            while(j >= 0 && numbers.get(j) > key){
                numbers.set(j+1, numbers.get(j));
                j = j -1;
            }

            numbers.set(j+1, key);
            
        }
        return true;
    }
    
}
