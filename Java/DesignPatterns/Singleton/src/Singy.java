public class Singy {
	private static Singy instance;

	public static Singy getInstance(){
		if(instance == null) instance = new Singy();

		return instance;
	}

	private String name;
	private Singy() {} //private constructor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
