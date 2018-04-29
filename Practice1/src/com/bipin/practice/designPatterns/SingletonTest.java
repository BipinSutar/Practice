package com.bipin.practice.designPatterns;

enum MySingletonEnum {
	INSTANCE;
	int i;

	public static MySingletonEnum getInstance() {
		return INSTANCE;
	}

	public void show() {
		System.out.println("I " + i);
	}
}

class MySingleton {
	private MySingleton() {
		System.out.println(MySingleton.class.getName() + " Instance created ");
	}

	private static MySingleton singletonInstance = null;

	public static MySingleton getMySingletonInstance() {
		if (singletonInstance == null) {
			synchronized (MySingleton.class) {
				if (singletonInstance == null) {
					singletonInstance = new MySingleton();
				}
			}

		}
		return singletonInstance;
	}

	public void printSing() {
		System.out.println("Hllo from Singleton");
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				MySingleton in = MySingleton.getMySingletonInstance();
				in.printSing();

			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				MySingleton in = MySingleton.getMySingletonInstance();
				in.printSing();

			}
		});
		t1.start();
		t2.start();
		MySingletonEnum.getInstance().show();
	}

}
