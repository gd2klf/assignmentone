package edu.grl.utility;

/**
 * Created by Greg on 3/24/17.
 */
public class DoubleLinkedList<T> {
    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private long size;

    public DoubleLinkedList(){
        head = tail = null;
        size = 0;
    }

    public DoubleLinkedList( T obj ){
        head = new DoubleListNode<T>(obj, null, null);
        tail = head;
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
        //Inserting in the middle is special case, so handle separately.
        if( index == 0 ){
            head = new DoubleListNode<T>(obj, null, head);

            if(head.getNextNode() != null)
                head.getNextNode().setPrevNode(head);

            //If the list was empty, tail now = head
            if(size == 0)
                tail = head;
            size++;

            return;
        }
        //Inserting at end is another special case, so handle separately
        if( index == size ){
            tail = new DoubleListNode<T>(obj, tail, null);

            if(tail.getPrevNode() != null)
                tail.getPrevNode().setNextNode(tail);

            //If the list was empty, tail now = head
            if(size == 0)
                head = tail;
            size++;
            return;

        }
        //Inserting in the middle from the front to make faster
        if( index <= size/2) {
            DoubleListNode<T> prev = head;
            for (long counter = 1; counter <= index; counter++) {
                DoubleListNode<T> curr = prev.getNextNode();
                if (counter == index) {
                    addNewMiddleNode(obj, curr);
                    return;
                }
                //Set prev to null because counter will be incremented.
                prev = curr;
            }
        }
        //Inserting in the middle from the back to make faster
        else{
            DoubleListNode<T> next = tail;
            for (long counter = size - 2; counter >= index; counter--) {
                DoubleListNode<T> curr = next.getPrevNode();
                if (counter == index) {
                    addNewMiddleNode(obj, curr);
                    return;
                }
                //Set prev to null because counter will be incremented.
                next = curr;
            }
        }
    }

    private void addNewMiddleNode(T obj, DoubleListNode<T> curr){
        DoubleListNode<T> newNode = new DoubleListNode<T>(obj, curr.getPrevNode(),curr  );
        newNode.getPrevNode().setNextNode(newNode);
        newNode.getNextNode().setPrevNode(newNode);
        size++;
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

        if( index == size - 1)
            return tail.getObj();

        //If in front half, start from the front.
        if( index <= size/2) {
            DoubleListNode<T> curr = head;
            for (long counter = 1; counter <= index; counter++) {
                curr = curr.getNextNode();
                if (counter == index)
                    return curr.getObj();
            }
        }
        //If in back half, start from the back.
        else{
            DoubleListNode<T> curr = tail;
            for (long counter = size-2; counter > 0; counter--) {
                curr = curr.getPrevNode();
                if (counter == index)
                    return curr.getObj();
            }
        }
        //Code should never get here
        throw new Exception( "LinkedList invalid function - getItem");
    }

    public void removeItem( long index )throws IndexOutOfBoundsException, Exception
    {
        if( index < 0 || index > (size - 1) ){
            throw new IndexOutOfBoundsException("Invalid index " + index + " specified for list of size " + size + "." );
        }

        if( index == 0 )
        {
            head=head.getNextNode();

            if(head != null)
                head.setPrevNode(null);

            size--;

            //If single node or empty, tail = head;
            if(size <= 1)
                tail = head;

            return;
        }

        if( index == size - 1){
            tail=tail.getPrevNode();
            tail.setNextNode(null);
            size--;
            //If single node or empty, head = tail;
            if(size <=1)
                head = tail;
            return;

        }

        //If in front half, start from the front.
        if( index <= size/2) {
            DoubleListNode<T> curr = head;
            for (long counter = 1; counter <= index; counter++) {
                curr = curr.getNextNode();
                if (counter == index){
                    removeMiddle(curr);
                    return;
                }
            }
        }
        //If in back half, start from the back.
        else{
            DoubleListNode<T> curr = tail;
            for (long counter = size-2; counter > 0; counter--) {
                curr = curr.getPrevNode();
                if (counter == index) {
                    removeMiddle(curr);
                    return;
                }
            }
        }
    }

    private void removeMiddle(DoubleListNode<T> node) throws Exception {
        if( node == null)
            return;

        DoubleListNode<T> prev = node.getPrevNode();
        DoubleListNode<T> next = node.getNextNode();
        if( prev == null ){
            throw new Exception("prev was null when removing node in middle of list. A bug has occurred.");
        }
        if( next == null ){
            throw new Exception("next was null when removing node in middle of list. A bug has occurred.");
        }
        prev.setNextNode(next);
        next.setPrevNode(prev);
        size --;
    }

    public void clear() throws Exception
    {
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
