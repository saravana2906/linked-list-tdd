package com.sars.tdd.linkedlist;



public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size;

    @Override
    public void add(T elementToAdd) {
        Node<T>  element = new Node<T>();
        element.setElement(elementToAdd);
        element.setNextElement(null);
        if(tail == null){
            head = element;
        } else {
            tail.setNextElement(element);
        }
        tail = element;
        this.size++;
    }

    @Override
    public void remove(int positionToRemove) {
    	checkIndex(positionToRemove);
    	Node<T> previousElement = null;
    	Node<T> currentElement = this.head;

    	for(int position = 0; position < this.size(); position ++) {
    		if(positionToRemove == position) {
    			if(positionToRemove == 0) {
    				if(currentElement.getNextElement()!=null) {
    					this.head = currentElement.getNextElement();
    				} else {
    					this.head = null;
    					if(this.size() == 1) {
    						this.tail = null;
    					}
    				}
    			} else if(positionToRemove == this.size() -1 ){
    				previousElement.setNextElement(currentElement.getNextElement());
    				this.tail = previousElement;
    			}else {
    				previousElement.setNextElement(currentElement.getNextElement());
    			}
    			break;
    		} else {
    			previousElement = currentElement;
    			currentElement = currentElement.getNextElement();
    		}
    	}
    	this.size --;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int expectedPosition) throws IndexOutOfBoundsException {
        int currentPosition = 0;
        checkIndex(expectedPosition);
        Node<T> currentElement = head;
        T element = null;
        while(currentPosition <= expectedPosition){
            if(currentPosition == expectedPosition){
            	element = currentElement.getElement();
            	break;
            }
            currentElement = currentElement.getNextElement();
            currentPosition++;
        }
        return element;
    }

    @Override
    public void insertAtPosition(int position, T elementToInsert) {
    	this.checkIndex(position);
    	Node<T> newNode = new Node<T>();
    	newNode.setElement(elementToInsert);
    	if(position == 0) {
    		newNode.setNextElement(this.head);
    		this.head = newNode;
    	} else {
    		Node<T> previousElement = this.head;
    		Node<T> currentElement = this.head.getNextElement();
    		for(int currentPosition = 1; currentPosition < this.size ; currentPosition++) {
    			if(currentPosition == position) {
    				previousElement.setNextElement(newNode);
    				newNode.setNextElement(currentElement);
    				break;
    			}
    			previousElement = currentElement;
    			currentElement = currentElement.getNextElement();
    		}
    	}
    	this.size++;
    }

    @Override
    public boolean contains(T elementToCheck) {
    	Node<T> currentElement  = this.head;
    	for(int currentPosition=0;currentPosition < this.size();currentPosition++) {
    		if(currentElement.getElement().equals(elementToCheck)) {
    			return true;
    		}
    	}
        return false;
    }

    private void checkIndex(int expectedIndex){
        if(expectedIndex >= this.size() || expectedIndex < 0){
            throw new IndexOutOfBoundsException("Index out of bounds Error when trying to access Index "
                    + expectedIndex +" but size is "+ this.size());
        }
    }
    
    public String toString() {
    	if(this.size()==0) {
    		return "[]";
    	}
    	StringBuffer list = new StringBuffer("[");
    	Node<T> currentElement = this.head;
    	for(int position=0;position < this.size();position++) {
    		list.append(currentElement.getElement().toString()+",");
    		currentElement = currentElement.getNextElement();
    	}
    	list.trimToSize();
    	list.deleteCharAt(list.length()-1);
    	list.append(']');
    	return list.toString();	
    }

}
