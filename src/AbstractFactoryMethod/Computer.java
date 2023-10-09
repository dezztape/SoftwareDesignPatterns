package AbstractFactoryMethod;

public abstract class Computer { // Абстрактный супер класс

    public abstract String getRAM(); // Абстрактный метод для RAM

    public abstract String getHDD(); // Абстрактный метод для HDD

    public abstract String getCPU(); // Абстрактный метод для CPU

    @Override
    public String toString() { // Переопределение метода toString() для получения строкового представления объекта
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}
