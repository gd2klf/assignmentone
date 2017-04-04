package edu.grl.test;

import edu.grl.utility.EmptyQueueException;
import edu.grl.utility.Queue;

/**
 * Created by Greg on 3/23/17.
 */
public class QueueTest {

    public static void testQueue() throws Exception {

        Queue<String> queue = new Queue<String>();

        System.out.println("Create an empty queue. isEmpty() returns:" + queue.isEmpty());

        String testString = new String("Test String");
        queue.enQueue( testString );
        System.out.println("Add an entry to the list. isEmpty() returns:" + queue.isEmpty() );

        queue = new Queue<String>();
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

        System.out.println( "Added six items to queue number 1 through 6. getSize() returned" + queue.getSize() );
        for(int counter = 0; counter< 6; counter++)
        {
            System.out.println( "deQueue() returned:" + queue.deQueue() );
        }
        System.out.println( "Empty queue now. isEmpty() returned:" + queue.isEmpty());

        System.out.println( "Queue volume test. Create a 1000000 size queue.");

        queue = new Queue<String>();
        for( int counter = 0; counter < 1000000; counter++ ) {
            String test = new String("Test String");
            queue.enQueue(test);
        }
        System.out.println("Queue created. call deQueue 1000000 times.");

        for( int counter = 0; counter < 1000000; counter++ ) {
            queue.deQueue();
        }

        System.out.println("Queue is empty. isEmpty() =" + queue.isEmpty() );
    }
}