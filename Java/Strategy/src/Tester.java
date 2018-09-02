import abilities.Boxing;
import abilities.Kicking;

public class Tester {
	public static void main(String[] args) {
		Warrior groot = new Warrior();
		groot.setAbility(new Boxing());
		groot.engage();
		groot.engage();
		groot.setAbility(new Kicking());
		groot.engage();
	}
}
