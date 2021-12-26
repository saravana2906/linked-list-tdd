package com.sars.tdd.linkedlist;

public interface LinkedList <T>{
    void add(T elementToAdd);
    void remove(int position);
    int size();
    void insertAtPosition(int position,T elementToInsert);
    boolean contains(T elementToCheck);
    T get(int i);
}
