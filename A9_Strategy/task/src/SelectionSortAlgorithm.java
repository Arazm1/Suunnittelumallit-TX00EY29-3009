package A9_Strategy.task.src;

import java.util.List;

public class SelectionSortAlgorithm implements AlgorithmStrategy{

    @Override
    public boolean processSorting(List<Integer> numbers){
        System.out.println("Sorting with SelectionSort algorithm..");

        int arrayLength = numbers.size();
        for(int i = 0; i<arrayLength; i++){

            int min_idx = i;

            //Iterate through the unsorted and find the (next) minimum.
            for(int j = i +1; j<arrayLength; j++){
                if(numbers.get(j) < numbers.get(i)){
                    min_idx = j;
                }
            }

            //Move the (next) smallest element to its correct position
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(min_idx));
            numbers.set(min_idx, temp);
            
        }
        return true;
    }
    
}