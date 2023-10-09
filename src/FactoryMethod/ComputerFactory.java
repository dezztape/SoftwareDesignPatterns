package FactoryMethod;

public class ComputerFactory { // Фабрика для создания компьютеров

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) // Сравнивает тип сигнала, игнорируя регистр (PC или pc)
            return new PC(ram, hdd, cpu); // Если тип - "PC", создается и возвращается объект класса PC
        else if ("Server".equalsIgnoreCase(type))
            return new Server(ram, hdd, cpu); // Если тип - "Server", создается и возвращается объект класса Server
        return null; // Если тип не определен или некорректен, возвращается null
    }
}
