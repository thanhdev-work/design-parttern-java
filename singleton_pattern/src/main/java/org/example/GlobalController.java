package org.example;

public class GlobalController {

    public final static EagerInitializedSingleton EAGER_INITIALIZED_SINGLETON = EagerInitializedSingleton.getInstance();

    public final static LazyInitializedSingleton LAZY_INITIALIZED_SINGLETON = LazyInitializedSingleton.getInstance();

    public final static ThreadSafeSingleton THREAD_SAFE_SINGLETON = ThreadSafeSingleton.getInstance();

}
