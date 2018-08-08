package L12InterfacesExercise.Ex07FoodShortage;

class Rebel implements Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }
}
