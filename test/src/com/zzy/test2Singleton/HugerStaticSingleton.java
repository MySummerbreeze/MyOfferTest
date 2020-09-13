package com.zzy.test2Singleton;

/**
 * 次优解：
 * @author user
 *
 */

public class HugerStaticSingleton {
	//线程安全
	private static HugerStaticSingleton instance;
	
	static {
		instance = new HugerStaticSingleton();
	}
	private HugerStaticSingleton() {}
	public static HugerStaticSingleton getInstance() {
		return instance;
	}
}
