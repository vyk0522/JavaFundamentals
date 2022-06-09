package com.onejava.practice;

public class Sample001_Main {
    public static void main(String[] args) {
        A a = new B();
        a.m1(); // Bm1

    }

}

abstract class A{  // class can contain 0 or many abstract methods
     void m1() {
        System.out.println("Am1");
    }
     abstract Number m2();
}

class B extends A{
     void m1() {
        System.out.println("Bm1");
    }

    @Override
    public Integer m2() {  // same type or subtype, same access level or wider, same signature
      return 0;
    }

}

enum E{
    // int i; // We can not keep other members without enum constant
    E(){ // We can keep con alone

    }
}
