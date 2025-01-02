package original;

public class CpuBoundExample {

	public static void main(String[] args) {
		CpuBoundExample cpuBoundExample = new CpuBoundExample();
		cpuBoundExample.action();
	}

	public long action() {
		long start = System.currentTimeMillis();

		for(int i = 0; i < 5; i++) {
			coreTask();
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + "ms");
		return end - start;
	}

	private static void coreTask() {
		int upperLimit = 10000000;
		int count = calculatePrimes(upperLimit);
	}

	private static int calculatePrimes(int limit) {
		int count = 0;
		for (int i = 2; i <= limit; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPrime(int number) {
		if (number < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}