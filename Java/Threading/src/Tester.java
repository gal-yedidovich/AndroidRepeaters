public class Tester {
	public static void main(String[] args) throws InterruptedException {
		/*/
		new MyThread().start();
		new Thread(new AnotherExample()).start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Hello from main thread");
			Thread.sleep(1);
		}

		//inline thread
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("i'm working from inline");
			}
		});

		//inline thread with lambda
		new Thread(() -> System.out.println("running from inline thread with lambda"));

		RemCtrlThread rct = new RemCtrlThread();
		new Thread(rct).start();

		Thread.sleep(2500);
		rct.die();
		/*/

		new Thread(new RaceCar("Bubu car", 100)).start();
		new Thread(new RaceCar("Groot car", 200)).start();
		new Thread(new RaceCar("Deadpool car", 250)).start();
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Bubu is the king");
	}
}

class AnotherExample implements Runnable {

	@Override
	public void run() {
		System.out.println("call from runnable class");
	}
}

//exercise 1
class RemCtrlThread implements Runnable {
	private boolean isAlive = true;

	@Override
	public void run() {
		int count = 0;
		while (isAlive) {
			System.out.println(++count);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void die() {
		isAlive = false;
	}
}

//exercise 2
class RaceCar implements Runnable {
	private static int place = 0;

	private String name;
	private int distance = 0, speed;

	RaceCar(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}

	@Override
	public void run() {
		while (distance++ < 100) {
			System.out.println(name + " is at " + distance);
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " has finished the race at place:" + ++place);
	}
}