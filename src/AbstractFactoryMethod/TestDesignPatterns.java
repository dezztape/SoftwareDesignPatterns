package AbstractFactoryMethod;

public class TestDesignPatterns { //создание потребительского класс,который обеспечит точку входа для создания подклассов
    public static void main(String[] args) {

        testAbstractFactory(); // Вызываем метод для тестирования абстрактной фабрики
    }
    private static void testAbstractFactory() {
        // Создаем компьютер PC с помощью фабрики PCFactory
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        // Создаем сервер с помощью фабрики ServerFactory
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        // Выводим информацию о конфигурации созданных компьютеров
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}