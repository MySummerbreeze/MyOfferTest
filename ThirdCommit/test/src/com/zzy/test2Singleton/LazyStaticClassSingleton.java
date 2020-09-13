package com.zzy.test2Singleton;
/**
 * 最优解：实现按需创建实例（实现私有静态内部类，来创建实例）
 * 一个私有静态内部类，类中提供一个静态的final的实例对象
 * 一个getInstance方法，用来返回私有静态内部类中的实例对象
 * 一个该类的无参数构造函数
 * 
 * @author user
 *
 */
public class LazyStaticClassSingleton {
    private static class SingletonHodler {
        private static final LazyStaticClassSingleton ourInstance = new LazyStaticClassSingleton();
    }

    public static LazyStaticClassSingleton getInstance() {
        return SingletonHodler.ourInstance;
    }

    private LazyStaticClassSingleton() {}
}
