package A20_Iterator.task.src;

import java.util.Iterator;

public interface Sequence {
    void add(Integer element);

    Iterator<Integer> iterator();
    
}
