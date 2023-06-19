import java.util.*;

public class deque {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new LinkedList<>();

		deque.add(1);
		deque.add(2);
		deque.add(3);
        deque.add(4);
        deque.add(5);

		System.out.print("#1 for문을 이용한 순회 : ");
		for (int de : deque) {
			System.out.print(de + " ");
		}
		System.out.println();

        System.out.print("#2 Iterator를 이용한 순회 1 : ");
		for (Iterator<Integer> it = deque.iterator(); it.hasNext();) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

        System.out.print("#3 Iterator를 이용한 순회 2 : ");
		Iterator<Integer> it = deque.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
        System.out.println();

        System.out.print("#4 역순순회 : ");
        Iterator<Integer> reverseIterator = deque.descendingIterator();
        while (reverseIterator.hasNext()) {
            int elem = reverseIterator.next();
            System.out.print(elem+" ");
        }
        System.out.println();

        sc.close();
	}
}
