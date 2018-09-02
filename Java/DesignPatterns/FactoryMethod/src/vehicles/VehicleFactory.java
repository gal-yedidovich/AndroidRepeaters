package vehicles;

public class VehicleFactory {

	public Vehicle createVehicle(String type) {
		switch (type.toLowerCase()) {
			case "car": case "private":   return new Car();
			case "bike": case "motor":    return new Bike();
			case "truck":                 return new Truck();
			default:                      throw new IllegalArgumentException("invalid type");
		}
	}
}
