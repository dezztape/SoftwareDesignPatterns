package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Класс Vehicle, реализующий интерфейс Cloneable для поддержки клонирования
class Vehicle implements Cloneable
{
  private List<String> vehicleList;

  public Vehicle()
  {
    this.vehicleList = new ArrayList<String>();
  }

  public Vehicle(List<String> list)
  {
    this.vehicleList = list;
  }

  public void insertData()
  {
    // Вставка данных в список
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList()
  {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException
  {
    // Создание копии списка данных
    List<String> tempList = new ArrayList<String>();

    for(String s : this.getVehicleList())
    {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    // Создание объекта Vehicle и вставка данных
    Vehicle a = new Vehicle();
    a.insertData();

    // Клонирование объекта a для создания объекта b
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze"); // Добавление нового элемента

    // Вывод данных из оригинального объекта a и клонированного объекта b
    System.out.println(a.getVehicleList());
    System.out.println(list);

    // Удаление элемента из клонированного объекта
    b.getVehicleList().remove("Audi A4");
    System.out.println(list);

    // Вывод данных из оригинального объекта a
    System.out.println(a.getVehicleList());
  }
}
