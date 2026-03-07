package A9_Strategy.task.src;


import java.util.List;

public class CycleSortAlgorithm implements AlgorithmStrategy{

    @Override
    public boolean processSorting(List<Integer> numbers){
        System.out.println("Sorting with SelectionSort algorithm..");

        int arrayLength = numbers.size();
        int writes = 0;
        for(int cycle_start = 0; cycle_start<= arrayLength - 2; cycle_start++){

            int item = numbers.get(cycle_start);

            //Count all the smaller elements on the right side of item and find the position 
            // where to put the item.
            int pos = cycle_start;
            for(int j = cycle_start + 1; j < arrayLength; j++){
                if(numbers.get(j) < item){
                    pos++;
                }
            }

            //If item in correct position already
            if(pos == cycle_start){
                continue;
            }

            //Ignores the duplicate elements
            while(item == numbers.get(pos)){
                pos += 1;
            }

            //Set the eitem to correct position
            if(pos != cycle_start){
                int temp = item;
                item = numbers.get(pos);
                numbers.set(pos, temp);
                writes++;
            }

            while(pos != cycle_start){
                pos = cycle_start;

                for(int i = cycle_start + 1; i < arrayLength; i++){
                    if(numbers.get(i) < item){
                        pos += 1;
                    }
                }

                while(item == numbers.get(pos)){
                    pos += 1;
                }

                if(item != numbers.get(pos)){
                    int temp = item;
                    item = numbers.get(pos);
                    numbers.set(pos, temp);
                    writes++;
                }
            }
        }

        return true;
    }
    
}
