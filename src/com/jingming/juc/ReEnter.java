package com.jingming.juc;

import java.util.concurrent.locks.*;

/**
 * 可重入
 * @author admin
 *
 */
public class ReEnter {
	
	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		lock.lock();
		try {
			System.out.println("main");
			m1();
		} finally {
			lock.unlock();
		}
	}

	private static void m1() {
		lock.lock();
		try {
			System.out.println("m1");
			m2();
		} finally {
			lock.unlock();
		}
	}

	private static void m2() {
		lock.lock();
		try {
			System.out.println("m2");
		} finally {
			lock.unlock();
		}
	}
}
