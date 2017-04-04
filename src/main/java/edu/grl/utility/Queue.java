package edu.grl.utility;

import java.util.LinkedList;

/**
 * Created by Greg on 3/23/17.
 */
public class Queue<T> {
    private DoubleLinkedList<T> dblLinkList;

    public Queue(){
        dblLinkList = new DoubleLinkedList<T>();
    }

    public boolean isEmpty(){
        return dblLinkList.isEmpty();
    }

    public void enQueue( T addObj ) throws IndexOutOfBoundsException{
        dblLinkList.addItem( addObj, 0 );
    }

    public T deQueue() throws EmptyQueueException, Exception {
        if( dblLinkList.isEmpty() == true)
            throw new EmptyQueueException("deQueue called on empty queue.");
        long index = dblLinkList.getSize() - 1;
        T obj = dblLinkList.getItem( index);
        dblLinkList.removeItem(index);
        return obj;
    }

    public long getSize(){return dblLinkList.getSize();}
}