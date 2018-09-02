import vehicles.Vehicle;
import vehicles.VehicleFactory;

public class Tester {
	public static void main(String[] args) {
		VehicleFactory factory = new VehicleFactory();

		Vehicle v1 = factory.createVehicle("car");
		Vehicle v2 = factory.createVehicle("motor");
		v1.drive();
		v2.drive();

		Vehicle[] zoo = {
				factory.createVehicle("bike"),
				factory.createVehicle("truck"),
				factory.createVehicle("private"),
		};

		for(Vehicle v : zoo) v.drive(); //polymorphic call

	}
}
