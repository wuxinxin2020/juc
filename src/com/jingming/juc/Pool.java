package com.jingming.juc;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {
	
	public static void main(String[] args) throws InterruptedException {
		int nThreads = 2;
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		Set<Thread> set = new HashSet<>();
		final ThreadLocal<String> th = new ThreadLocal<String>();
		for (int i = 0; i < 100; i++) {
			final int index = i;
			executor.execute(()->{
				th.set("i=" + index);
				Thread currentThread = Thread.currentThread();
				set.add(currentThread);
				//String s = th.get();
				//th.remove();
				//System.out.println(s);
			});
		}
		Thread.sleep(1000);
		System.out.println(set.size());
		System.out.println(th.get());
		executor.shutdown();
	}

}
