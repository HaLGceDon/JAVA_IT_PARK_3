package VasiliGrigorev;

public class Main {

    public static void main(String[] args) {
	Car car = Car.Builder()
            .manufacturer("Lada")
            .model(("Vesta"))
            .color("red")
            .maxSpeed(200)
            .fuelAmount(55)
            .fuelConsumption(7)
            .power(106);
    }
}
