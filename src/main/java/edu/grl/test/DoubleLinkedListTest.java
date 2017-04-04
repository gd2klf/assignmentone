package edu.grl.test;

import edu.grl.utility.DoubleLinkedList;

import java.sql.Timestamp;

/**
 * Created by Greg on 3/28/17.
 */
public class DoubleLinkedListTest {
    static public void testDoubleLinkedList() throws Exception {
        DoubleLinkedList<String> dList = new DoubleLinkedList<String>();
        System.out.println("Created empty list. getSize() returned:" + dList.getSize());
        DoubleLinkedList<String> dList2 = new DoubleLinkedList<String>( new String("Test"));
        System.out.println("Created a list with one item. getSize() returned:" + dList2.getSize());

        //Insert an item in a location that is outside of the existing list
        DoubleLinkedList<String> lList = new DoubleLinkedList<String>();

        //Insert 10 records in sequence
        String str = new String("test");
        for( long counter = 0; counter < 10; counter ++){
            lList.addItem(str + counter, counter);
        }
        System.out.println("Created 10 item list from 0 to 9");
        printList(lList);

        System.out.println("Add 7a before 7 and 2a before 2.");
        //Insert an item at 7 and 2 and verify the contents.
        lList.addItem( str + 7 + "a", 7);
        lList.addItem( str + 2 + "a", 2);
        printList(lList);

        System.out.println("Size = " + lList.getSize());

        System.out.println("Remove item 2a (2) and 7a (7)");

        lList.removeItem(2);
        lList.removeItem(7);

        printList(lList);

        System.out.println("Clear the list and show the size.");
        lList.clear();
        System.out.println("Cleared list has size:" + lList.getSize());

        final long TEST_SIZE = 1000000;
        System.out.println("Test large list of size " + TEST_SIZE);

        String test = new String("test");
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        for( long counter = 0; counter< TEST_SIZE; counter ++)
        {
            //Always add to the beginning of the list to make it faster.
            list.addItem(test, 0);
        }

        System.out.println("Created list with size:" + list.getSize());

        System.out.println("Remove items from list and track tiem.");
        //Track time for fun.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp prevTime = timestamp;
        for( long counter = TEST_SIZE - 1; counter >= 0; counter --) {
            if( (counter + 1)%100000 == 0){
                Timestamp currTime = new Timestamp(System.currentTimeMillis());
                long diff = currTime.getTime() - prevTime.getTime();
                System.out.println( "Removing item " + counter + ". Time since last write:" + diff);
                prevTime = currTime;
            }
            list.removeItem(counter);
        }

        System.out.println("Create another list of size:" + TEST_SIZE);
        test = new String("test");
        list = new DoubleLinkedList<String>();

        for( long counter = 0; counter< TEST_SIZE; counter ++)
        {
            //Always add to the beginning of the list to make it faster.
            list.addItem(test + counter, counter);
        }

        System.out.println("Created list. getSize() returns:" + list.getSize());
        list.clear();
        System.out.println("After clear, getSize() returns:" + list.getSize() );
    }

    static void printList( DoubleLinkedList<String> strList ){
        System.out.println("Printing list:");
        String tmp = null;
        for(int counter = 0; counter < strList.getSize(); counter ++ ){
            try {
                tmp = strList.getItem(counter);
            }
            catch(Exception ex){
                System.out.println("Exception:" + ex.getMessage());
                return;
            }
            System.out.print("strList[" + counter +"]=" +  tmp + ";" );
        }
        System.out.print("\n");
    }
}

