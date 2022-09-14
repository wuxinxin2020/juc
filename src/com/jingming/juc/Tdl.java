package com.jingming.juc;

public class Tdl extends Thread {
	
	private static Object o1 = new Object();
	
	private static Object o2 = new Object();
	
	public Tdl(String name) {
		super.setName(name);
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		if("t1".equals(t.getName())) {
			synchronized (o1) {
				try {
					Thread.sleep(1000);
					synchronized (o2) {
						System.out.println(t.getName() + "run....");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if("t2".equals(t.getName())) {
			synchronized (o2) {
				try {
					Thread.sleep(1000);
					synchronized (o1) {
						System.out.println(t.getName() + "run....");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Tdl t1 = new Tdl("t1");
		Tdl t2 = new Tdl("t2");
		t1.start();
		t2.start();
	}
	
}
