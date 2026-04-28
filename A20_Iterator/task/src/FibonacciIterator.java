package A20_Iterator.task.src;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer>{


    private Node current;
    private Node head;
    private Node tail;

    public FibonacciIterator(FibonacciSequence fs){
        this.current = fs.getHead();
    }

    @Override
    public boolean hasNext(){
        return this.current != null;
    }

    @Override
    public Integer next(){
        int data = current.getData();
        current = current.getNext();
        return data;
    } 
}
