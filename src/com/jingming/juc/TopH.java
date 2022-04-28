package com.jingming.juc;

import java.util.concurrent.TimeUnit;

import sun.misc.Launcher;

public class TopH {
	
	public static void main(String[] args) {
		new Thread(()->{
			while(true) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1").start();
		
		new Thread(()->{
			while(true) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t2").start();
	}

}
