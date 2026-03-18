package A9_Strategy.task.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListSorter {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> originalDataLong = new ArrayList<>();
        List<Integer> originalDataShort = new ArrayList<>();
        

        AlgorithmContext algorithmSorter = new AlgorithmContext(new SelectionSortAlgorithm());

        System.out.println("Enter the length of the long List you wish to sort (Min 1000): ");
        int listLength1 = scanner.nextInt();
        while(listLength1 < 1000){
            System.out.println("List must be longer than 1000! Enter new number: ");
            listLength1 = scanner.nextInt();
        }
        System.out.println("Long list length: " + listLength1);
        /* 
        if(listLength1<1000){
            listLength1 = 1000;
        }
        */
        for(int i = 0; i< listLength1; i++){
            originalDataLong.add(random.nextInt(100));
        }

        System.out.println("Enter the length of the short List you wish to sort (Max 300): ");
        int listLength2 = scanner.nextInt();
        while(listLength2 > 300){
            System.out.println("List must be shorter than 300! Enter new number: ");
            listLength2 = scanner.nextInt();
        }
        System.out.println("Short list length: " + listLength2);
        /*
        if(listLength2 > 300){
            listLength2 = 300;
        }
        */
        for(int i = 0; i<listLength2; i++){
            originalDataShort.add(random.nextInt(100));
        }




        while(true){
            System.out.println("Select Sorting method: ");
        System.out.println("1. Selection Sort");
        System.out.println("2. Cycle Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> algorithmSorter.setStrategy(new SelectionSortAlgorithm());
            case 2 -> algorithmSorter.setStrategy(new CycleSortAlgorithm());
            case 3 -> algorithmSorter.setStrategy(new InsertionSortAlgorithm());
            case 4 -> {
                System.out.println("Ending the program..");
                return;
            }
            default ->{
                System.out.println("Invalid choice!");
                //return;
            }       
        }

        List<Integer> longDataToSort = new ArrayList<>(originalDataLong);
        List<Integer> shortDataToSort = new ArrayList<>(originalDataShort);
        long sortingSuccessfulLongData = algorithmSorter.processSorting(longDataToSort);
        long sortingSuccessfulShortData = algorithmSorter.processSorting(shortDataToSort);

        System.out.println("Sorted!");
        System.out.println(" Time for long list : " + sortingSuccessfulLongData + "ns");
        System.out.println(" Time for short list : " + sortingSuccessfulShortData + "ns");

        }
        
    }
    
}
