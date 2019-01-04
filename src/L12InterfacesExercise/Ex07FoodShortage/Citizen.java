package L12InterfacesExercise.Ex07FoodShortage;

class Citizen implements Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}
