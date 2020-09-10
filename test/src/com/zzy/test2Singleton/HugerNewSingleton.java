package com.zzy.test2Singleton;

public class HugerNewSingleton {
	//线程不安全
	//创建实例,对象引用不可修改
	private static final HugerNewSingleton instance = new HugerNewSingleton();
	//静态的构造方法
	private HugerNewSingleton() {}
	//面向全局的方法获取到该对象实例
	public static HugerNewSingleton getInstance() {
		return instance;
	}
}
