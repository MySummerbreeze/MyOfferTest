package com.zzy.test2Singleton;

public class HugerNewSingleton {
	//�̲߳���ȫ
	//����ʵ��,�������ò����޸�
	private static final HugerNewSingleton instance = new HugerNewSingleton();
	//��̬�Ĺ��췽��
	private HugerNewSingleton() {}
	//����ȫ�ֵķ�����ȡ���ö���ʵ��
	public static HugerNewSingleton getInstance() {
		return instance;
	}
}
