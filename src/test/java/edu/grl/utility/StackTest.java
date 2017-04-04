package edu.grl.utility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Greg on 3/23/17.
 */
public class StackTest {

    @Test
    public void isEmpty() throws Exception {

        Stack<String> stack = new Stack<String>();

        assertEquals(true, stack.isEmpty());

        String testString = new String("Test String");
        stack.push( testString );

        assertEquals( false, stack.isEmpty() );
    }

    @Test
    public void pushpop() throws Exception {

        Stack<String> stack = new Stack<String>();
        String testString1 = new String("Test String 1");
        stack.push( testString1 );

        String testString2 = new String("Test String 2");
        stack.push( testString2 );

        String testString3 = new String("Test String 3");
        stack.push( testString3 );

        String testString4 = new String("Test String 4");
        stack.push( testString4 );

        String testString5 = new String("Test String 5");
        stack.push( testString5 );

        String testString6 = new String("Test String 6");
        stack.push( testString6 );

        assertSame( testString6, stack.pop() );
        assertSame( testString5, stack.pop() );
        assertSame( testString4, stack.pop() );
        assertSame( testString3, stack.pop() );
        assertSame( testString2, stack.pop() );
        assertSame( testString1, stack.pop() );
        assertEquals( true, stack.isEmpty());
    }

    @Test
    public void NegativeTests() throws Exception {
        Stack<String> stack = new Stack<String>();
        try {
            stack.pop();
            fail("Exception not thrown");
        } catch (EmptyStackException ex) {
            assertEquals("pop called on empty queue.", ex.getMessage());
        }
    }

    @Test
    public void volumeTest1000000() throws Exception {

        Stack<String> stack = new Stack<String>();
        for( int counter = 0; counter < 1000000; counter++ ) {
            String test = new String("Test String");
            stack.push(test);
        }
        assertEquals(false, stack.isEmpty() );
        for( int counter = 0; counter < 1000000; counter++ ) {
            stack.pop();
        }
        assertEquals( true, stack.isEmpty() );
        return;
    }
}