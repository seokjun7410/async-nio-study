package singleloop;

public class SingleLoopTest {

	public static void main(String[] args) {
		SingleLoopTest singleLoopTest = new SingleLoopTest();
		singleLoopTest.doTest();
	}

	public void doTest() {
		System.out.println("SingleLoopTest.main");
		long start = System.currentTimeMillis();

		for(int i = 0; i < 5; i++) {
			CpuBoundExample cpuBoundExample = new CpuBoundExample();
			cpuBoundExample.action();

			IoBoundExample ioBoundExample = new IoBoundExample();
			ioBoundExample.action();
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + "ms");
	}
}
