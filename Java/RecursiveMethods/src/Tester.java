import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		countDown(9);

		String[] na = new String[]{"One", "Two", "Three"};
		printNames(na, 0);

		ArrayList<Integer> a = new ArrayList<>();
		a.add(10);

		System.out.println(a.get(1));
	}

	static void countDown(int count) {
		if (count > 0) {
			System.out.println(count--);
			countDown(count);
		}
	}

	static void printNames(String[] names, int index) {
		if (index >= 0 && index < names.length) {
			System.out.println(names[index++]);
			printNames(names, index);
		}
	}
}
