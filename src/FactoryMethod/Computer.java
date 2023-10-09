package FactoryMethod;

public abstract class Computer { // абстрактный супер класс, где хранятся методы нашей фабрики

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU(); // абстрактные методы для получения значний

    @Override
    public String toString() { // Переопределение метода для получения строкового представления объекта

        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ",CPU = " + this.getCPU();
    }
}