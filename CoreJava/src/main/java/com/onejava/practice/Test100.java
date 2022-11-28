package com.onejava.practice;

public class Test100 {
    public static void main(String[] args) {
        Base b = new Child();
        b.m1();
        Base.m2();
    }
}

class Base{

    void m1(){
        System.out.println("M1");
    }

    static void m2(){
        System.out.println("M2");
    }

}

class Child extends Base{

    void m3(){
        m2();
    }


}

