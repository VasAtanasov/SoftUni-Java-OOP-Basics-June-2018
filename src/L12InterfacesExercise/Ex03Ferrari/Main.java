package L12InterfacesExercise.Ex03Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException, IllegalClassFormatException {
        Car ferrari = new Ferrari(reader.readLine());

        System.out.println(String.format("%s/%s/%s/%s",
                ferrari.getModel(),
                ferrari.useBrakes(),
                ferrari.pushTheGasPedal(),
                ferrari.getDriver()));

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }

}

