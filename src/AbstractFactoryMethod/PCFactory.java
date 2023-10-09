package AbstractFactoryMethod;

public class PCFactory implements ComputerAbstractFactory { // Фабрика для создания компьютеров
    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu){ //конструктор
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public Computer createComputer() { // метод которыйй имплементируется из интерфейса
        return new PC(ram,hdd,cpu); // создание компьютера с характеристиками
    }
}