package singleloop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OneThreadTest {
	public static void main(String[] args) {
		OneThreadTest oneThreadTest = new OneThreadTest();
		oneThreadTest.doTest();
	}

	public void doTest() {
		System.out.println("OneThreadTest.main");
		long start = System.currentTimeMillis();

		// Create a single-thread executor
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		List<CompletableFuture<Void>> futures = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			CpuBoundExample cpuBoundExample = new CpuBoundExample();
			IoBoundExample ioBoundExample = new IoBoundExample();

			CompletableFuture<Void> cpuFuture = CompletableFuture.runAsync(cpuBoundExample::action,
				singleThreadExecutor);
			CompletableFuture<Void> ioFuture = CompletableFuture.runAsync(ioBoundExample::action,
				singleThreadExecutor);

			futures.add(cpuFuture);
			futures.add(ioFuture);
		}

		// Wait for all futures to complete
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(
			futures.toArray(new CompletableFuture[0]));

		try {
			allFutures.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + "ms");

		// Shutdown the executor
		singleThreadExecutor.shutdown();
	}

}
