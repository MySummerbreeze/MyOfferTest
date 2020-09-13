package com.zzy.test2Singleton;

/**
 * ���Ž⣺
 * @author user
 *
 */

public class HugerStaticSingleton {
	//�̰߳�ȫ
	private static HugerStaticSingleton instance;
	
	static {
		instance = new HugerStaticSingleton();
	}
	private HugerStaticSingleton() {}
	public static HugerStaticSingleton getInstance() {
		return instance;
	}
}
