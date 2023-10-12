package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Subject определяет методы для регистрации, удаления и оповещения наблюдателей
interface Subject
{
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Класс DeliveryData реализует интерфейс Subject и представляет данные о доставке
class DeliveryData implements Subject
{
    private List<Observer> observers;
    private String location;

    public DeliveryData()
    {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj)
    {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj)
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
        for(Observer obj : observers)
        {
            obj.update(location);
        }
    }

    public void locationChanged()
    {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation()
    {
        return "YPlace";
    }
}

// Интерфейс Observer определяет метод обновления наблюдателей
interface Observer
{
    public void update(String location);
}

// Класс Seller реализует интерфейс Observer и представляет продавца
class Seller implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Класс User реализует интерфейс Observer и представляет пользователя
class User implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Класс DeliveryWarehouseCenter реализует интерфейс Observer и представляет центр доставки
class DeliveryWarehouseCenter implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern
{
    public static void main(String[] args)
    {
        // Создание объекта DeliveryData, который представляет данные о доставке
        DeliveryData topic = new DeliveryData();

        // Создание наблюдателей (продавца, пользователя и центра доставки)
        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Регистрация наблюдателей в объекте DeliveryData
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Изменение местоположения и оповещение наблюдателей
        topic.locationChanged();

        // Удаление одного из наблюдателей (центра доставки)
        topic.unregister(obj3);

        System.out.println();

        // Снова изменение местоположения и оповещение наблюдателей (без центра доставки)
        topic.locationChanged();
    }
}