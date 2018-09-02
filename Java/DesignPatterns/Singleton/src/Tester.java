public class Tester {
	public static void main(String[] args) {
		Singy one = Singy.getInstance(); //new Singy();
		one.setName("bubu");

		Singy two = Singy.getInstance();
		two.setName("Groot");

		System.out.println(one.getName());
	}
}
