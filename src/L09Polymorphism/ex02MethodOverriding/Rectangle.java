package L09Polymorphism.ex02MethodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;


    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return this.sideA;
    }

    public double getSideB() {
        return this.sideB;
    }

    public Rectangle(double side) {
        this(side, side);
    }

    public double area() {
        return this.getSideA() * this.getSideB();
    }
}
