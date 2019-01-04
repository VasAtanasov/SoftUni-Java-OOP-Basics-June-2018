package L12InterfacesExercise.Ex06BirthdayCelebrations;

public class Citizen implements Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDay;

    public Citizen(String name, int age, String id, String birthDay) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }
}
