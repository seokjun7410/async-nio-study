import original.OriginalTest;
import singleloop.CompletableFutureTest;
import singleloop.TwoThreadTest;
import singleloop.OneThreadTest;
import singleloop.SingleLoopTest;

public class Test {

	public static void main(String[] args) {
		OriginalTest originalTest = new OriginalTest();
		originalTest.doTest();

		SingleLoopTest singleLoopTest = new SingleLoopTest();
		singleLoopTest.doTest();

		OneThreadTest oneThreadTest = new OneThreadTest();
		oneThreadTest.doTest();

		TwoThreadTest twoThreadTest = new TwoThreadTest();
		twoThreadTest.doTest();

		CompletableFutureTest completableFutureTest = new CompletableFutureTest();
		completableFutureTest.doTest();
	}

}
