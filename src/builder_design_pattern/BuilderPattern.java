package builder_design_pattern;

// Класс Vehicle представляет транспортное средство и имеет параметры: мотор, колеса и подушки безопасности
class Vehicle
{
  private String engine;
  private int wheel;
  private int airbags;

  public String getEngine()
  {
    return this.engine;
  }

  public int getWheel()
  {
    return this.wheel;
  }

  public int getAirbags()
  {
    return this.airbags;
  }

  // Приватный конструктор класса Vehicle, принимающий объект класса VehicleBuilder
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Внутренний класс VehicleBuilder, используется для пошагового построения объекта Vehicle
  public static class VehicleBuilder
  {
    private String engine;
    private int wheel;
    private int airbags;

    // Конструктор VehicleBuilder, принимающий обязательные параметры: мотор и количество колес
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Метод для установки количества подушек безопасности и возврата самого объекта VehicleBuilder
    public VehicleBuilder setAirbags(int airbags)
    {
      this.airbags = airbags;
      return this;
    }

    // Метод для построения объекта Vehicle с установленными параметрами
    public Vehicle build()
    {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern
{
  public static void main(String[] args)
  {
    // Создание объектов car и bike с помощью VehicleBuilder
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Вывод параметров автомобиля (car) и мотоцикла (bike)
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
