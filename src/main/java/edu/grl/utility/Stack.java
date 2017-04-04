package edu.grl.utility;



/**
 * Created by Greg on 3/23/17.
 */
public class Stack<T> {
    private LinkedList<T> lList;

    //Create a new empty stack
    public Stack(){
        lList = new LinkedList<T>();
    }

    //Create a new stack with one item
    public boolean isEmpty(){
        return lList.isEmpty();
    }

    //Add a new item on the front of the stack.
    public void push( T addObj ) throws IndexOutOfBoundsException{
        lList.addItem( addObj, 0 );
    }

    //Return the front item of the stanck and remove it from the list.
    public T pop() throws EmptyStackException, Exception {
        if( lList.isEmpty() == true)
            throw new EmptyStackException("pop called on empty queue.");

        T obj = lList.getItem(0);
        lList.removeItem(0);
        return obj;
    }
    
    public long getSize() { return lList.getSize(); }
}
