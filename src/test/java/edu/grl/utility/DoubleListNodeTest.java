package edu.grl.utility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Greg on 3/28/17.
 */
public class DoubleListNodeTest {
    @Test
    public void setPrevNode() throws Exception {
        String test1 = new String("test1");
        String test2 = new String("test2");
        String test3 = new String("test3");
        DoubleListNode<String> head = new DoubleListNode<String>( test1,null,  null);
        DoubleListNode<String> next = new DoubleListNode<String>( test2, null, null);
        DoubleListNode<String> tail = new DoubleListNode<String>( test3, null, null);
        head.setNextNode(next);
        next.setPrevNode(head);
        next.setNextNode(tail);
        tail.setPrevNode(next);

        assertEquals(null, head.getPrevNode());
        assertSame(next, head.getNextNode());

        assertSame(null, head.getPrevNode());
        assertSame(head, next.getPrevNode());
        assertSame(next, head.getNextNode());
        assertSame(tail, next.getNextNode());
        assertEquals(null, tail.getNextNode());

        assertSame(test1, head.getObj());
        assertSame(test2, next.getObj());
        assertSame(test3, tail.getObj());
    }

}