package edu.grl.utility;

/**
 * Created by Greg on 3/28/17.
 */
public class DoubleListNode<T> {
    private T obj = null;
    private DoubleListNode<T> prevNode = null;
    private DoubleListNode<T> nextNode = null;

    public DoubleListNode( T newObj, DoubleListNode<T> prev, DoubleListNode<T> next){
        obj = newObj;
        prevNode = prev;
        nextNode = next;
    }

    public void setPrevNode(DoubleListNode<T> prev) {this.prevNode = prev; }
    public DoubleListNode<T> getPrevNode() {
        return prevNode;
    }

    public void setNextNode(DoubleListNode<T> next) {
        this.nextNode = next;
    }
    public DoubleListNode<T> getNextNode() {
        return nextNode;
    }

    public T getObj() {
        return obj;
    }
}
