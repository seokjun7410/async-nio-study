import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

		Iterable<Integer> myIter = () ->
			new Iterator<>() {
				int i = 0;
				final static int MAX = 10;
				@Override
				public boolean hasNext() {
					return i < MAX;
				}

				@Override
				public Integer next() {
					return ++i;
				}
			};

		for (Integer integer : myIter) {
			System.out.println(integer);
		}
	}
}
