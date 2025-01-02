import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ob {
	//Reactive Programming, ReactiveX, Functional Reactive Programming
	//Reactive 라는 용어가 추상적이여서. 사람마다 떠올리는게 다를 수 있다.
	//Reactive 이벤트에 따라 처리하는 방식

	//리액티브를 잘 설명할 수 있는 개념 -> Duality : 상대성 -> 수학적인 용어에서 온듯
	//Observer pattern -> reactive Streams 표준 이야기로 이어진다. -> java9 api로 들어감

	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		//List -> Collection - > Iterable (for each loop 사용가능 interface)
//		Iterable<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//		for (Integer i : list) { // for-each
//			System.out.println("i = " + i);

//		Iterable<Integer> myIter = () ->
//			new Iterator<>() {
//				int i = 0;
//				final static int MAX = 10;
//
//				@Override
//				public boolean hasNext() {
//					return i < MAX;
//				}
//
//				@Override
//				public Integer next() {
//					return ++i;
//				}
//			};
//
//		for (Integer integer : myIter) {
//			System.out.println(integer);
//		}

		//Iterable 과 Observalbe은 상대성이다. 목적은 같지반 방식이 정반대에 있는 것.
		//Iterable은 Pull 방식 땡겨온다.  Obser
		//for (Integer integer : myIter) {
		//			System.out.println(integer);
		//		}
		//는 사실 내부적으로
//		for(Iterator<Integer> it = myIter.iterator(); it.hasNext()){
//			System.out.println(it.next());
	//  }
//		인데 . it.next가 pull 하는 방식을 취하고 있다.
		// observable은 push 방식

		Observer ob = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				System.out.println(Thread.currentThread().getName()+" "+arg);
			}
		};

		// 끝을 표현하는 Copmlete 방법이 없다.
		// Exception 처리가 패턴에 녹아있지 않다.

		IntObservable io = new IntObservable();
		io.addObserver(ob);

		io.run();

		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(io);

		System.out.println(Thread.currentThread().getName()+"EXIT");
		es.shutdown();
	}

	static class IntObservable extends Observable implements Runnable{

		@Override
		public void run() {
			for(int i = 1; i <=10; i++){
				setChanged();
				notifyObservers(i);
			}
		}
	}
}
