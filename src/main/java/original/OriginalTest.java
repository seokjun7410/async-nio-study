package original;

public class OriginalTest {

	public static void main(String[] args) {
		OriginalTest originalTest = new OriginalTest();
		originalTest.doTest();
	}

	public void doTest() {
		System.out.println("CompletableFutureTest.main");

		CpuBoundExample cpuBoundExample = new CpuBoundExample();
		long time1 = cpuBoundExample.action();

		IoBoundExample ioBoundExample = new IoBoundExample();
		long time2 = ioBoundExample.action();

		System.out.println("Total: "+(time1+time2));
	}
}
