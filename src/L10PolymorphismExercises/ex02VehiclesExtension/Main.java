package L10PolymorphismExercises.ex02VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {
    private static BufferedReader reader;
    private static DecimalFormat df;
    private static Map<String, Vehicle> vehicles;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        vehicles = new LinkedHashMap<>();
        df = new DecimalFormat("0.##");
    }

    public static void main(String[] args) throws IOException {
        Vehicle car = getVehicle.apply(reader.readLine());
        add(car);
        Vehicle truck = getVehicle.apply(reader.readLine());
        add(truck);
        Vehicle bus = getVehicle.apply(reader.readLine());
        add(bus);

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            String vehicleType = tokens[1];
            double value = Double.parseDouble(tokens[2]);
            switch (command) {
                case "Drive":
                    if (vehicles.get(vehicleType).drive(value)) {
                        System.out.println(String.format("%s travelled %s km", vehicleType, df.format(value)));
                    } else {
                        System.out.println(String.format("%s needs refueling", vehicleType));
                    }
                    break;
                case "DriveEmpty":
                    if (vehicles.get(vehicleType).driveAirConOff(value)) {
                        System.out.println(String.format("%s travelled %s km", vehicleType, df.format(value)));
                    } else {
                        System.out.println(String.format("%s needs refueling", vehicleType));
                    }

                    break;
                case "Refuel":
                    try {
                        vehicles.get(vehicleType).refuel(value);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }

        vehicles.values()
                .forEach(System.out::println);
    }

    private static void add(Vehicle vehicle) {
        vehicles.put(vehicle.getClass().getSimpleName(), vehicle);
    }

    private static Function<String, Vehicle> getVehicle = s -> {
        String[] tokens = s.split("\\s+");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);
        if ("Car".equals(vehicleType)) {
            return new Car(fuelQuantity, fuelConsumption, tankCapacity);
        } else if ("Truck".equals(vehicleType)) {
            return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        } else {
            return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
    };
}
