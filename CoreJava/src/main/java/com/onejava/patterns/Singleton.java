package com.onejava.patterns;

/*
1. Make Constructor private
2. Create static getInstance() to return instance

3. To prevent cloning of Singleton object >  Override clone method and throw an exception from it.
4. To prevent duplicate instance via Serialization > implement readObject() to return same instance or use enum.
 */
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

/*
    Lazy Initialization with double lock Method
 */
class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    /*
       If two threads get inside if statement concurrently when the instance is null.
       One thread enters, creates instance and exists. Now blocked thread enters and creates another instance
       To avoid that use instance check again in synchronized block
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized(Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

enum Singleton3 {
    INSTANCE;
}
