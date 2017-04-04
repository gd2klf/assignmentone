package edu.grl.main;

import edu.grl.test.DoubleLinkedListTest;
import edu.grl.test.QueueTest;
import edu.grl.test.StackTest;


/**
 * Created by Greg on 3/23/17.
 */
public class main {
    public static void main(String [ ] args) {
        System.out.println("Main app starting.");

        System.out.println("\n\n******Test queue.");
        try {
            QueueTest.testQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\n******Test stack.");
        try {
            StackTest.testStack();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\n******Test double linked list.");
        try {
            DoubleLinkedListTest.testDoubleLinkedList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
