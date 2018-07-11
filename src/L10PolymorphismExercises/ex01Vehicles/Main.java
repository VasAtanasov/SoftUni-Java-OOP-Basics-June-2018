package L10PolymorphismExercises.ex01Vehicles;

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
    private static Map<String, Drivable> vehicles;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        vehicles = new LinkedHashMap<>();
        df = new DecimalFormat("0.##");
    }

    public static void main(String[] args) throws IOException {
        Drivable car = getVehicle.apply(reader.readLine());
        vehicles.put("Car", car);
        Drivable truck = getVehicle.apply(reader.readLine());
        vehicles.put("Truck", truck);

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
                case "Refuel":
                    vehicles.get(vehicleType).refuel(value);
                    break;
            }
        }

        vehicles.values()
                .forEach(System.out::println);
    }

    private static Function<String, Drivable> getVehicle = s -> {
        String[] tokens = s.split("\\s+");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        if ("Car".equals(vehicleType)) {
            return new Car(fuelQuantity, fuelConsumption);
        } else {
            return new Truck(fuelQuantity, fuelConsumption);
        }
    };
}
