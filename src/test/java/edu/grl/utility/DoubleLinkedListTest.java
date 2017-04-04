package edu.grl.utility;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Greg on 3/28/17.
 */
public class DoubleLinkedListTest {
    @Test
    public void getSize() throws Exception {
        DoubleLinkedList<String> dList = new DoubleLinkedList<String>();
        assertEquals(0, dList.getSize());

        DoubleLinkedList<String> dList2 = new DoubleLinkedList<String>( new String("Test"));
        assertEquals(1, dList2.getSize());
    }

    @Test
    public void addItem() throws Exception {

        //Insert an item in a location that is outside of the existing list
        DoubleLinkedList<String> lList = new DoubleLinkedList<String>();
        try{
            lList.addItem( new String(), 1 );
            fail( "Insert should have thrown IndexOutOfBoundsException" );
        }
        catch( IndexOutOfBoundsException ex){}

        //Insert 10 records in sequence
        String str = new String("test");
        for( long counter = 0; counter < 10; counter ++){
            lList.addItem(str + counter, counter);
            assertEquals(counter + 1, lList.getSize());
            printList(lList);
        }

        //Insert an item at 7 and 2 and verify the contents.
        lList.addItem( str + 7 + "a", 7);
        printList(lList);
        lList.addItem( str + 2 + "a", 2);
        printList(lList);
        assertEquals( 12, lList.getSize());
        for( long counter = 0; counter < lList.getSize(); counter ++){
            String tmp = lList.getItem( counter );
            if( counter< 2){
                assertEquals( tmp, str+counter);
            }
            else if (counter == 2 ){
                assertEquals( tmp, str + 2 + "a");
            }
            else if (counter < 8){
                assertEquals( tmp, str + (counter-1) );
            }
            else if (counter == 8 ){
                assertEquals( tmp, str + 7 + "a");
            }
            else {
                assertEquals(tmp, str + (counter - 2));
            }
        }

    }

    void printList( DoubleLinkedList<String> strList ){
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
            System.out.println("strList[" + counter +"]=" +  tmp );
        }
    }


    @Test
    public void getItem() throws Exception {
        DoubleLinkedList<String> lList = new DoubleLinkedList<String>();

        try{
            lList.getItem(-1);
            fail( "getItem(-1) should throw an exception");
        }
        catch(IndexOutOfBoundsException ex){}

        try{
            lList.getItem(0);
            fail( "getItem out of range should throw an exception");
        }
        catch(IndexOutOfBoundsException ex){}

        String str1 = new String("test1");
        for( long counter = 0; counter < 1000; counter ++){
            lList.addItem(new String("test" + counter), counter);
            assertEquals(counter + 1, lList.getSize());
        }

        try{
            lList.getItem(1000000);
            fail( "getItem out of range should throw an exception");
        }
        catch(IndexOutOfBoundsException ex){}
    }

    @Test
    public void removeItem() throws Exception {

        final String test = new String( "test" );
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        try{
            list.removeItem(-1);
            fail("Item should thrown an exception");
        }
        catch( IndexOutOfBoundsException ex ){
            assertEquals(ex.getMessage(),"Invalid index -1 specified for list of size 0." );
        }

        try{
            list.removeItem(0);
            fail("Item should thrown an exception");
        }
        catch( IndexOutOfBoundsException ex ){
            assertEquals(ex.getMessage(),"Invalid index 0 specified for list of size 0." );
        }

        list.addItem(test, 0);
        try{
            list.removeItem(1);
            fail("Item should thrown an exception");
        }
        catch( IndexOutOfBoundsException ex ){
            assertEquals(ex.getMessage(),"Invalid index 1 specified for list of size 1." );
        }

        list.removeItem(0);
        assertEquals(0, list.getSize());

        for(int counter = 0; counter < 10; counter ++){
            list.addItem(test+counter, counter);
        }

        //Remove test9, test6, and test0
        list.removeItem(9);
        list.removeItem(6);
        list.removeItem( 0);

        //Verify contents
        assertEquals("test1", list.getItem(0));
        assertEquals("test5", list.getItem(4));
        assertEquals("test7", list.getItem(5));
        assertEquals("test8", list.getItem(6));
        assertEquals(7, list.getSize());
    }

    @Test
    public void largeList() throws Exception {
        final long TEST_SIZE = 100000;
        //Create 1,000,000 size list;
        final String test = new String("test");
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        for( long counter = 0; counter< TEST_SIZE; counter ++)
        {
            //Always add to the beginning of the list to make it faster.
            list.addItem(test, 0);
        }

        //Remove from end to beginning. Should be slowest way.
        //Track time for fun.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp prevTime = timestamp;
        for( long counter = TEST_SIZE - 1; counter >= 0; counter --) {
            if( (counter + 1)%1000 == 0){
                Timestamp currTime = new Timestamp(System.currentTimeMillis());
                long diff = currTime.getTime() - prevTime.getTime();
                System.out.println( "Removing item " + counter + ". Time since last write:" + diff);
                prevTime = currTime;
            }
            list.removeItem(counter);
        }
    }

    @Test
    public void clear() throws Exception {
        final long TEST_SIZE = 1000000;
        //Create 1,000,000 size list;
        final String test = new String("test");
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        for( long counter = 0; counter< TEST_SIZE; counter ++)
        {
            //Always add to the beginning of the list to make it faster.
            list.addItem(test + counter, counter);
        }

        list.clear();
        assertEquals(0, list.getSize());
        try {
            list.getItem(0);
            fail("Should have thrown out of index error.");
        }
        catch( IndexOutOfBoundsException ex){
            //Success
            return;
        }
        catch(Exception ex)
        {
            fail("Threw wrong type of exception.");
        }
    }

    @Test
    public void isEmpty(){
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        assertEquals(true, list.isEmpty());

        try{
            list.addItem(new String("test0"), 0);
        }
        catch(Exception ex){
            fail("Unexpected exception: " + ex.getMessage());
        }
        assertEquals(false, list.isEmpty());

        try {
            list.clear();
        }
        catch( Exception ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }
}