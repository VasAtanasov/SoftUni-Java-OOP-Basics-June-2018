package L09Polymorphism.ex02MethodOverriding;

public class Square extends Rectangle {
    public Square(double side) {
        super(side);
    }

    @Override
    public double area() {
        return this.getSideA() * this.getSideA();
    }
}
