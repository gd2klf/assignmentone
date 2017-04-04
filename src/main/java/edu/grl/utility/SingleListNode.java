package edu.grl.utility;

/**
 * Created by Greg on 3/24/17.
 */
public class SingleListNode<T> {

    private T obj;
    private SingleListNode<T> nextNode;

    public SingleListNode( T newObj, SingleListNode<T> next){
        obj = newObj;
        nextNode = next;
    }

    public void setNextNode(edu.grl.utility.SingleListNode<T> next) {
        this.nextNode = next;
    }

    public edu.grl.utility.SingleListNode<T> getNextNode() {
        return nextNode;
    }

    public T getObj() {
        return obj;
    }
}
