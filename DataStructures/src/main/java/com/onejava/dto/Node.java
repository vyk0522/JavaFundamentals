package com.onejava.dto;


public class Node<X> {
    public X data;
    public Node<X> next;

    public Node(X data) {
        this.data = data;
    }

    public String toString() {
        return this.data.toString();
    }
}
