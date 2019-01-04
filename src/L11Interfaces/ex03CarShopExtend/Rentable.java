package L11Interfaces.ex03CarShopExtend;

public interface Rentable extends Car {
    Integer getMinRentDay();

    Double getPricePerDay();
}
