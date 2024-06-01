package com.my.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZomThread {
	private static ExecutorService service;
	static {
		service = Executors.newFixedThreadPool(500);
	}
	public static ExecutorService geExecutorService() {
		return service;
	}
}
