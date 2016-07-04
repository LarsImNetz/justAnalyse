package org.linuxx.moonserver.java7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestFutures {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestFutures.class);

	@Test
	public void testLearnFutures() throws Exception {

		final long startTime = System.currentTimeMillis();

		// we start 3 threads in parallel, with a runtime from (1000 + 1500 +
		// 1000) ms but we expect this will no longer run than 1500ms
		final T1000ms thread1 = new T1000ms();
		final T1500ms thread2 = new T1500ms();
		final T1000ms thread3 = new T1000ms();

		final ExecutorService executor = Executors.newFixedThreadPool(3);
		final Future<String> future1 = executor.submit(thread1);
		final Future<String> future2 = executor.submit(thread2);
		final Future<String> future3 = executor.submit(thread3);

		final String result1 = future1.get(1200, TimeUnit.MILLISECONDS);
		final String result2 = future2.get(1700, TimeUnit.MILLISECONDS);
		final String result3 = future3.get(1200, TimeUnit.MILLISECONDS);

		executor.shutdown();

		final long endTime = System.currentTimeMillis() - startTime;
		Assert.assertEquals("success", result1);
		Assert.assertEquals("success", result2);
		Assert.assertEquals("success", result3);
		System.out.println("Zeit: " + endTime);
		Assert.assertTrue(endTime >= 1500 && endTime < 2000);
	}

	private static class T1000ms implements Callable<String> {

		@Override
		public String call() throws Exception {
			try {
				Thread.sleep(1000);
			}
			catch (final InterruptedException e) {
				LOGGER.error(e.getMessage());
			}
			return "success";
		}
	}

	private static class T1500ms implements Callable<String> {

		@Override
		public String call() throws Exception {
			try {
				Thread.sleep(1500);
			}
			catch (final InterruptedException e) {
				LOGGER.error(e.getMessage());
			}
			return "success";
		}

	}
}
