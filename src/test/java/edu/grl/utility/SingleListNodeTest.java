package edu.grl.utility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Greg on 3/28/17.
 */
public class SingleListNodeTest {
    @Test
    public void setNextNode() throws Exception {
        String test = new String("test");
        SingleListNode<String> head = new SingleListNode<String>( test, null);
        SingleListNode<String> next = new SingleListNode<String>( test, null);
        head.setNextNode(next);
        assertEquals(next, head.getNextNode());

        assertSame(test, head.getObj());
    }
}