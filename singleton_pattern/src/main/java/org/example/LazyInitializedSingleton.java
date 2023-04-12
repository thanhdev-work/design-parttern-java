package org.example;

//case in single thread
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    //private constructor to avoid client applications to use constructor
    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
