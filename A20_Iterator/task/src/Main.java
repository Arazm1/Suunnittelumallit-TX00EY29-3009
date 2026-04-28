package A20_Iterator.task.src;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Sequence fibonacciSequence = new FibonacciSequence();

        /* 
        fibonacciSequence.add(17);
        fibonacciSequence.add(3);
        fibonacciSequence.add(-2);
        fibonacciSequence.add(0);
        */
        for (int i = 0; i < 10; i++) {
            fibonacciSequence.add(0);  // argument is ignored, value is computed internally
        }


        Iterator iterator = fibonacciSequence.iterator();

        while(iterator.hasNext()){
            System.out.println("In turn: " + iterator.next());
            // 'Enter' continues, 'q' stops
            String s = scanner.nextLine();
            if(s.equals("q")){
                break;
            }
        }
        
    }
    
}
