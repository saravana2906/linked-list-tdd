package com.sars.tdd.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LinkedListTests {

    @Test
    void Given_ListCreated_When_ElementIsAddedAtPosition_Then_ElementShouldBeReadAtPosition(){
        LinkedList<String> testSubject = new SinglyLinkedList<String>();
        String s = "First-Element";
        testSubject.add(s);
       String actual = testSubject.get(0);
       assertEquals(s,actual);
    }
    
    @Test
    void Given_ListCreated_When_NumberOfElementsAddedtoList_Then_SizeofListShouldBeNumberOfElementsAdded() {
    	 LinkedList<String> testSubject = new SinglyLinkedList<String>();
         String s = "First-Element";
         testSubject.add(s);
         String sec = "Second-Element";
         testSubject.add(sec);
         assertEquals(2, testSubject.size());
    }
    
    @Test
    void Given_ListCreated_When_IndexIsgreaterThanSize_Then_GetShouldThrowIndexOutOfBoundException() {
    	 LinkedList<String> testSubject = new SinglyLinkedList<String>();
         String s = "First-Element";
         testSubject.add(s);
         assertThrows(IndexOutOfBoundsException.class,() -> { testSubject.get(2);} );
    }
    
    @Test
    void Given_ListCreated_When_IndexIsLessThanZero_Then_GetShouldThrowIndexOutOfBoundException() {
    	 LinkedList<String> testSubject = new SinglyLinkedList<String>();
         assertThrows(IndexOutOfBoundsException.class,() -> { testSubject.get(-1);} );
    }
    
    @Test
    void Given_ListCreatedAndAddedElements_When_CheckingContainsWithElementPresentInList_Then_ContainsShouldReturnTrue() {
   	 LinkedList<String> testSubject = new SinglyLinkedList<String>();
     String s = "First-Element";
     testSubject.add(new String("First-Element"));
     assertEquals(true, testSubject.contains(s));
    }
    
    @Test
    void Given_ListCreatedAndAddedElements_When_CheckingContainsWithElementNotPresentInList_Then_ContainsShouldReturnFalse() {
   	 LinkedList<String> testSubject = new SinglyLinkedList<String>();
     String s = "Some-Element";
     testSubject.add(new String("First-Element"));
     assertEquals(false, testSubject.contains(s));
    }
    
    @Test
    void Given_ListCreatedAndAddedTwoElements_When_RemoveElementAtPosition0_Then_ElementShouldRemovedAndGetPosition0ShouldReturn2ndElement() {
    	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.add(new String("Second-Element"));
    	testSubject.remove(0);
    	assertEquals("Second-Element",testSubject.get(0));
    }
    
    @Test
    void Given_ListCreatedAndAddedTwoElements_When_ToStringCalled_Then_ShouldReturnStringinCommaSeparatedFormat() {
     	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.add(new String("Second-Element"));
    	System.out.println(testSubject.toString());
    	assertEquals("[First-Element,Second-Element]",testSubject.toString());
    }
    
    @Test
    void Given_ListCreatedAndEmpty_When_ToStringCalled_Then_ShouldReturnEmpty() {
     	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	System.out.println(testSubject.toString());
    	assertEquals("[]",testSubject.toString());
    }
    
    @Test
    void Given_ListCreatedAndAddedTwoElements_When_InsertAtPosition0_Then_getPosition0ShouldReturnInsertedValue() {
    	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.add(new String("Second-Element"));
    	String newHead = "New-Head";
    	testSubject.insertAtPosition(0,newHead);
    	assertEquals("New-Head",testSubject.get(0));
    	assertNotEquals("First-Element", testSubject.get(0));
    	assertEquals(3, testSubject.size());
    }
    
    @Test
    void Given_ListCreatedAndAddedTwoElements_When_InsertAtEndPosition_Then_getPositionEndShouldReturnInsertedValue() {
    	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.add(new String("Second-Element"));
    	String newSecond = "New-Second";
    	testSubject.insertAtPosition(1,newSecond);
    	assertEquals("New-Second",testSubject.get(1));
    	assertNotEquals("Second-Element", testSubject.get(1));
    	assertEquals(3, testSubject.size());
    }
    
    @Test
    void Given_ListCreatedAndAddedOneElement_When_RemovedOneElement_Then_SizeShouldReturnZero() {
    	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.remove(0);
    	assertEquals(0, testSubject.size());	
    }
    
    @Test
    void Given_ListCreatedAndAddedMoreThanOneElement_When_RemovedElementAtPosition0_Then_SizeShouldReturn1() {
    	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.add(new String("Second-Element"));
    	testSubject.remove(0);
    	assertEquals(1, testSubject.size());	
    }
    
    @Test
    void Given_ListCreatedAndAddedMoreThanOneElement_When_RemovedElementAtEndPosition_Then_SizeShouldReturn1() {
    	LinkedList<String> testSubject = new SinglyLinkedList<String>();
    	testSubject.add(new String("First-Element"));
    	testSubject.add(new String("Second-Element"));
    	testSubject.remove(1);
    	assertEquals(1, testSubject.size());	
    }
    

}
