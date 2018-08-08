package L12InterfacesExercise.Ex03Ferrari;

public class Ferrari implements Car {
    private final String MODEL;

    private String driver;

    public Ferrari(String driver) {
        this.MODEL = "488-Spider";
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.MODEL;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGasPedal() {
       return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
