package com.onejava.dataStructures;

import java.util.Arrays;

public class Stack<E> {
    private E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(){
        elements = (E[]) new Object[10];
    }

    public void push(E element){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = element;
    }

    public E pop(){
        if (size == 0){
            throw new IllegalStateException("Stack is empty");
        }
        E poppedElement = elements[--size];
        elements[size] = null;
        return poppedElement;
    }

    public E peek(){
        if (size == 0){
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1];
    }

    public boolean contains(E element){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public E access(E element){
        while(size > 0){
            E poppedElement = pop();
            if(poppedElement.equals(element)){
                return poppedElement;
            }
        }
        throw new IllegalArgumentException("Could not find the element on the stack: " + element);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");  // C B A

        System.out.println(stack.peek()); // C
        System.out.println(stack.pop());  // C
        System.out.println(stack.contains("A")); // true
        System.out.println(stack.access("B"));   // B
        System.out.println(stack.isEmpty());     // false (since "A" still there)
    }

}
