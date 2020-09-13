package com.zzy.test2Singleton;
/**
 * ���Ž⣺ʵ�ְ��贴��ʵ����ʵ��˽�о�̬�ڲ��࣬������ʵ����
 * һ��˽�о�̬�ڲ��࣬�����ṩһ����̬��final��ʵ������
 * һ��getInstance��������������˽�о�̬�ڲ����е�ʵ������
 * һ��������޲������캯��
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
