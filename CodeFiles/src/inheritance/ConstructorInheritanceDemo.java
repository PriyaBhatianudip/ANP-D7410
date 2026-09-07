package CodeFiles.src.inheritance;

class Vehicle
{
    String brand;
    int year;

    Vehicle(String brand, int year)
    {
        this.brand = brand;
        this.year = year;

        System.out.println("Vehicle constructor called");
    }
}

class Car extends Vehicle
{
    String model;
    String fuelType;

    Car(String brand, int year, String model, String fuelType)
    {
        super(brand, year);

        this.model = model;
        this.fuelType = fuelType;

        System.out.println("Car constructor called");
    }

    void display()
    {
        System.out.println("Brand    : " + brand);
        System.out.println("Year     : " + year);
        System.out.println("Model    : " + model);
        System.out.println("Fuel     : " + fuelType);
    }
}

public class ConstructorInheritanceDemo
{
    public static void main(String[] args)
    {
        Car c = new Car("Toyota", 2025, "Fortuner", "Diesel");

        System.out.println();
        c.display();
    }
}

//