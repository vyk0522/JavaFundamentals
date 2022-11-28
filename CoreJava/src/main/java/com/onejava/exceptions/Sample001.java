package com.onejava.exceptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample001 {
    public static void main(String[] args) throws IOException{
        m1();
        m2();
        m3();
        m4();
        System.out.println("Done");
    }

    private static void m1() {
        try {
            throw new NumberFormatException();
            // System.out.println();  // CTE Unreachable code as remaining statement won't execute when exception has been thrown
        } catch (NumberFormatException ex) {

        }
    }

    private static void m2() {
        try{

        } catch (RuntimeException ex){

        } /*catch (NumberFormatException ex){   // CTE Unreachable code as above catch handles this ex too

        } */
    }

    private static void m3() {
        try{
            // Types must be disjoint. Exceptions can not extend one another
            // NumberFormatException extends IllegalArgumentException

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException /*| RuntimeException*/ e){

        } catch (NumberFormatException  /* | IllegalArgumentException*/  ex){

        } /*catch(ArithmeticException ex){  // this exception is already handled

        }*/
    }

    private static void m4() throws IOException { // Try with Resources
        try (FileInputStream in = new FileInputStream("input.txt");
             FileOutputStream out = new FileOutputStream("output.txt")) {
            out.write(in.readAllBytes());
        }
    }
}
