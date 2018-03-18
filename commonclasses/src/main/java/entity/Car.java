package entity;

import java.io.Serializable;

public class Car implements Serializable{

    private static final long serialVersionUID = 1190476516911661470L;
    private int year;
    private int engineSize;
    private double price;

    public Car(){}

    public Car(int year, int engineCapacity) {
        this.year = year;
        this.engineSize = engineCapacity;
    }

    public Car(int year, double purchasingPrice){
        this.year = year;
        this.price = purchasingPrice;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getEngineSize() {
        return engineSize;
    }
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", engineSize=" + engineSize +
                ", price=" + price +
                '}';
    }
}
