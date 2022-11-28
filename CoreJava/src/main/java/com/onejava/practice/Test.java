package com.onejava.practice;

public class Test implements P1, P2{
    public static void main(String[] args) {
        new Test().m1();
    }
    @Override
    public void m1() {
        P1.super.m1();
    }
}

interface P1{
    default void m1(){
        System.out.println("P1");
    }
}

interface P2{
    default void m1(){
        System.out.println("P2");
    }
}