package edu.grl.utility;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Greg on 3/23/17.
 */
public class QueueTest {

    @Test
    public void isEmpty() throws Exception {

        Queue<String> queue = new Queue<String>();

        assertEquals(true, queue.isEmpty());

        String testString = new String("Test String");
        queue.enQueue( testString );

        assertEquals( false, queue.isEmpty() );
    }

    @Test
    public void enQueuedeQueue() throws Exception {

        Queue<String> queue = new Queue<String>();
        String testString1 = new String("Test String 1");
        queue.enQueue( testString1 );

        String testString2 = new String("Test String 2");
        queue.enQueue( testString2 );

        String testString3 = new String("Test String 3");
        queue.enQueue( testString3 );

        String testString4 = new String("Test String 4");
        queue.enQueue( testString4 );

        String testString5 = new String("Test String 5");
        queue.enQueue( testString5 );

        String testString6 = new String("Test String 6");
        queue.enQueue( testString6 );

        assertEquals( testString1, queue.deQueue() );
        assertEquals( testString2, queue.deQueue() );
        assertEquals( testString3, queue.deQueue() );
        assertEquals( testString4, queue.deQueue() );
        assertEquals( testString5, queue.deQueue() );
        assertEquals( testString6, queue.deQueue() );
        assertEquals( true, queue.isEmpty());
    }

    @Test
    public void NegativeTests() throws Exception {
        Queue<String> queue = new Queue<String>();
        try {
            queue.deQueue();
            fail("Exception not thrown");
        } catch (EmptyQueueException ex) {
            assertEquals("deQueue called on empty queue.", ex.getMessage());
        }
    }

    @Test
    public void volumeTest1000000() throws Exception {

        Queue<String> queue = new Queue<String>();
        for( int counter = 0; counter < 1000000; counter++ ) {
            String test = new String("Test String");
            queue.enQueue(test);
        }
        assertEquals(false, queue.isEmpty() );
        for( int counter = 0; counter < 1000000; counter++ ) {
            queue.deQueue();
        }
        assertEquals( true, queue.isEmpty() );
        return;
    }
}