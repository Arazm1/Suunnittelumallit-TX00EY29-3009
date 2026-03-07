package A9_Strategy.task.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListSorter {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> originalData = new ArrayList<>();

        AlgorithmContext algorithmSorter = new AlgorithmContext(new SelectionSortAlgorithm());

        System.out.println("Enter the length of the List you wish to sort: ");
        int listLength = scanner.nextInt();
        for(int i = 0; i< listLength; i++){
            originalData.add(random.nextInt(1000));
        }


        System.out.println("Select Sorting method: ");
        System.out.println("1. Selection Sort");
        System.out.println("2. Cycle Sort");
        System.out.println("3. Insertion Sort");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> algorithmSorter.setStrategy(new SelectionSortAlgorithm());
            case 2 -> algorithmSorter.setStrategy(new CycleSortAlgorithm());
            case 3 -> algorithmSorter.setStrategy(new InsertionSortAlgorithm());
            default ->{
                System.out.println("Invalid choice!");
                return;
            }       
        }

        long sortingSuccessful = algorithmSorter.processSorting(originalData);
        System.out.println(sortingSuccessful);
        /* 
        if(sortingSuccessful){
            System.out.println("Sorting successful!");
        }
        else{
            System.out.println("Sorting failed!");
        }
            */
    }
    
}
