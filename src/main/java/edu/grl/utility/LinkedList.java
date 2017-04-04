package edu.grl.utility;

/**
 * Created by Greg on 3/24/17.
 */
public class LinkedList<T> {
    private SingleListNode<T> head = null;
    private long size = 0;

    public LinkedList(){}

    LinkedList( T obj ){
        head = new SingleListNode<T>(obj, null);
        size = 1;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void addItem(T obj, long index ) throws IndexOutOfBoundsException {
        if( index > size || index < 0){
            throw new IndexOutOfBoundsException("Invalid index " + index + " specified for list of size " + size);
        }
        //Setting head is special case, so handle separately.
        if( index == 0 ){
            SingleListNode<T> next = null;
            head = new SingleListNode<T>(obj, head);
            size++;
            return;
        }

        SingleListNode<T> prev = head;
        for(long counter = 1; counter <= index; counter ++) {
            SingleListNode<T> curr = prev.getNextNode();
            if( counter == index ){
                SingleListNode<T> newNode = new SingleListNode<T>(obj, curr);
                prev.setNextNode( newNode );
                size++;
                return;
            }
            //Set prev to null because counter will be incremented.
            prev = curr;
        }
    }

    public T getItem( long index ) throws IndexOutOfBoundsException, Exception {
        if(index < 0)
            throw new IndexOutOfBoundsException( "Invalid index, " + index + " must be 0 or larger" );

        if(index > (size-1))
            throw new IndexOutOfBoundsException( "Invalid index " + index + " specified for list of size " + size );

        if(index > Long.MAX_VALUE - 1)
            throw new IndexOutOfBoundsException( "Invalid index " + index + " is too large for this implementation." );

        if( index == 0 )
            return head.getObj();
        SingleListNode<T> curr = head;
        for( long counter = 1; counter <= index; counter++ ){
            curr = curr.getNextNode();
            if(counter == index)
                return curr.getObj();
        }
        //Code should never get here
        throw new Exception( "LinkedList invalid function - getItem");
    }

    public void removeItem( long index )throws IndexOutOfBoundsException
    {
        if( index < 0 || index > (size - 1) ){
            throw new IndexOutOfBoundsException("Invalid index " + index + " specified for list of size " + size + "." );
        }
        //Setting head is special case, so handle separately.
        if( index == 0 ){
            SingleListNode<T> newHead = head.getNextNode();
            head = newHead;
            size--;
            return;
        }

        SingleListNode<T> prev = head;
        for(long counter = 1; counter <= index; counter ++) {
            SingleListNode<T> curr = prev.getNextNode();
            if( counter == index ){
                prev.setNextNode( curr.getNextNode() );
                size--;
                return;
            }
            //Set prev to null because counter will be incremented.
            prev = curr;
        }
    }
    void clear() throws Exception
    {
        //Remove from end to beginning. Should be fast way.
        long sizeBeforeClear = size;
        for( long counter = 0; counter < sizeBeforeClear; counter ++) {
            try{
                removeItem(0);
            }
            //Should never happen.
            catch(IndexOutOfBoundsException ex){
                throw new Exception("Failure in LinkedList.clear. Bug exists in edu.grl.utility.LinnkedList class.");
            }

        }
    }
}