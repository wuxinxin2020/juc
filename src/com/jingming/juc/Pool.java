package com.jingming.juc;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Pool {
	
	public static void main(String[] args) throws InterruptedException {
		int nThreads = 2;
		Executor executor = Executors.newFixedThreadPool(nThreads);
		Set<Thread> set = new HashSet<>();
		final ThreadLocal<String> th = new ThreadLocal<String>();
		for (int i = 0; i < 1000000; i++) {
			final int index = i;
			executor.execute(()->{
				th.set("i=" + index);
				set.add(Thread.currentThread());
//				th.remove();
			});
		}
		Thread.sleep(1000);
		System.out.println(set.size());
	}

}
