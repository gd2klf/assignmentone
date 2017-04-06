package edu.grl.test;

import edu.grl.utility.Stack;

/**
 * Created by Greg on 3/23/17.
 */
public class StackTest {
    static public void testStack() throws Exception {

        Stack<String> stack = new Stack<String>();

        System.out.println("Create an empty stack. isEmpty() returns:" + stack.isEmpty());

        String testString = new String("Test String");
        stack.push( testString );
        System.out.println("Add a string. isEmpty() returns:" + stack.isEmpty() );

        stack.pop();

        System.out.println("Create a stack with 6 items from 1 to 6.");
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

        for(int counter = 0; counter < 6; counter  ++)
        {
            System.out.println("stackpop returned:" + stack.pop() );
        }

        System.out.println("isEmpty() returned:" + stack.isEmpty());

        final int TEST_SIZE = 1000000;

        System.out.println("Create a stack with size:" + TEST_SIZE);
        stack = new Stack<String>();
        for( int counter = 0; counter < TEST_SIZE; counter++ ) {
            String test = new String("Test String");
            stack.push(test);
        }

        System.out.println("getSize() returned:" + stack.getSize() );
        for( int counter = 0; counter < TEST_SIZE; counter++ ) {
            stack.pop();
        }

        System.out.println("After popping all items, isEmpty() returned:" +  stack.isEmpty() );
    }
}