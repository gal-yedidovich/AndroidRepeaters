import java.util.*;

public class Tester {
	public static void main(String[] args) {
		//Array List
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Hi");
		myList.add("Bye");
		myList.add("Die");

		System.out.println(myList.get(2));

		//Set - collection of uniques
		HashSet<Integer> nums = new HashSet<>();
		nums.add(1); //add new value
		nums.add(1); //already exists
		nums.add(5); //add new value
		nums.add(1); //already exists

		System.out.println("set size is: " + nums.size());

		System.out.println(nums.contains(5));

		//Map - collection of key value pairs
		HashMap<String, Integer> digists = new HashMap<>();
		digists.put("One", 1);
		digists.put("Two", 2);
		digists.put("Three", 3);
		digists.put("Four", 4);

		System.out.println(digists.get("Two"));

		for (Map.Entry<String, Integer> entry : digists.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		//exercise:

		HashMap<String, String> users = new HashMap<>();
		users.put("Bubu", "123");
		users.put("Turi", "Mac");
		users.put("Barak", "123");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String uName = sc.next();
		System.out.println("Enter pass:");
		String uPass = sc.next();

		if (uPass.equals(users.get(uName))) {
			System.out.println("Welcome");
		} else {
			System.out.println("Invalid login");
		}
	}
}
