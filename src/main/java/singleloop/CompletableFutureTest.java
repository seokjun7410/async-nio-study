package singleloop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

	public static void main(String[] args) {
		CompletableFutureTest completableFutureTest = new CompletableFutureTest();
		completableFutureTest.doTest();

	}

	public void doTest() {
		System.out.println("CompletableFutureTest.main");
		long start = System.currentTimeMillis();

		List<CompletableFuture<Void>> futures = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			CpuBoundExample cpuBoundExample = new CpuBoundExample();
			IoBoundExample ioBoundExample = new IoBoundExample();

			CompletableFuture<Void> cpuFuture = CompletableFuture.runAsync(cpuBoundExample::action);
			CompletableFuture<Void> ioFuture = CompletableFuture.runAsync(ioBoundExample::action);

			futures.add(cpuFuture);
			futures.add(ioFuture);
		}

		// Wait for all futures to complete
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

		try {
			allFutures.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + "ms");
	}
}
