package A20_Iterator.task.src;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Sequence fibonacciSequence = new FibonacciSequence();

        System.out.println("Press Enter for next number, 'q' to Exit.");

        while(true){
            fibonacciSequence.add();
            Iterator<Integer> iterator = fibonacciSequence.iterator();
            int last = 0;
            while(iterator.hasNext()){
                last = iterator.next();
            }
            System.out.println("Next: " + last);
            String s = scanner.nextLine();

            if(s.equals("q")){
                break;
            }
        }
        scanner.close();
    }
}