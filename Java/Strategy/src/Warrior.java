import abilities.FightAbility;

public class Warrior {
	private FightAbility ability;

	public void setAbility(FightAbility ability){
		this.ability = ability;
	}

	public void engage(){
		ability.attack();
	}
}
