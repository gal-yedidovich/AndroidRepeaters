public class Tester {
	public static void main(String[] args) {
		Pair<Integer> myPair = new Pair<>();

		myPair.setLeft(10);
		myPair.setRight(90);

		System.out.println(myPair);

		CoolPair<String, Boolean> anotherPair = new CoolPair<>();

		anotherPair.setLeft("my name is gal?");
		anotherPair.setRight(true);

		System.out.println(anotherPair);
	}
}
