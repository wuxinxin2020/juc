package com.jingming.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断
 * @author admin
 *
 */
public class Interrupt {
	
	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(()->{
			System.out.println("thread1 enter");
			//lock.lockInterruptibly();
			lock.lock();
			System.out.println("thread1 got lock");
		}, "thread1");
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		t1.interrupt();
		TimeUnit.SECONDS.sleep(100000);
	}
	
}
