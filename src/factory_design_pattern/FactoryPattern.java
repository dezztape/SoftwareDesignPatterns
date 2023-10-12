package factory_design_pattern;

abstract class Vehicle
{
	public abstract int getWheel(); // Метод для получения количества колес
	public String toString()
	{
		return "Wheel: " + this.getWheel();
	}
}

// Класс Car, наследуется от Vehicle, представляет автомобиль
class Car extends Vehicle
{
	int wheel;
	Car(int wheel)
	{
		this.wheel = wheel;
	}

	@Override
	public int getWheel()
	{
		return this.wheel;
	}
}

// Класс Bike, наследуется от Vehicle, представляет велосипед
class Bike extends Vehicle
{
	int wheel;
	Bike(int wheel)
	{
		this.wheel = wheel;
	}

	@Override
	public int getWheel()
	{
		return this.wheel;
	}
}

// Класс VehicleFactory, фабрика для создания объектов типа Vehicle
class VehicleFactory
{
	public static Vehicle getInstance(String type, int wheel)
	{
		if(type.equals("car")) // Используйте .equals() для сравнения строк
		{
			return new Car(wheel);
		}
		else if(type.equals("bike"))
		{
			return new Bike(wheel);
		}
		return null;
	}
}

public class FactoryPattern
{
	public static void main(String[] args)
	{
		// Создание объектов Car и Bike с использованием фабрики
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}