package FactoryMethod;

public class TestFactory {
    public static void main(String[] args) { // Главный метод для запуска программы
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500GB", "2.4 GHz"); // Создание объекта PC с помощью фабрики
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz"); // Создание объекта Server с помощью фабрики
        System.out.println("Factory PC Config::" + pc); // Вывод информации о конфигурации PC на консоль
        System.out.println("Factory Server Config::" + server); // Вывод информации о конфигурации Server на консоль
    }
}
