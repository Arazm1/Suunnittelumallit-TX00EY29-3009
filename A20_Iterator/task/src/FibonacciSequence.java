package A20_Iterator.task.src;

import java.util.Iterator;

public class FibonacciSequence implements Sequence{

    private Node head;
    private Node tail;


    public FibonacciSequence(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(Integer data){
        int value;
        if(head == null){
            value = 1;
        }
        if(head == tail){
            value = 1;
        }
        else{
            Node prev = head;
            while (prev.getNext() != tail) {
                prev = prev.getNext();
            }
            value = prev.getData() + tail.getData();
        }




        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
            //tail.setNext(head);
        }
    }

    public Node getHead(){
        return this.head;
    }

    @Override
    public Iterator<Integer> iterator(){
        return new FibonacciIterator(this);
    }
}