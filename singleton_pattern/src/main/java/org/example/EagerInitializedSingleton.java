package org.example;

public class EagerInitializedSingleton {
    //may be this instance not used
    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {

    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
