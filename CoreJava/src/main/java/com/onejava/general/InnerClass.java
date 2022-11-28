package com.onejava.general;

public class InnerClass {
    public static void main(String[] args) {
        A.B b = new A().new B();
        b.m1();
    }

}

class A{
    private String name = "a";
    private static int i = 7;

    void m1(){
        class C{

        }
    }

    A(){
        class D{

        }
    }

    {
        class E{

        }
    }

    static {
        class F{

        }
    }

    public class B{
        private String desc = "b";
        private static int j = 8;

        static void m2(){

        }

        void m1(){
            name = "c";
            desc = "d";
            i = 5;
            System.out.println(name + " " + desc + " " + i + j );
        }

    }
}
