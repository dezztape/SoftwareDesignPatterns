package AbstractFactoryMethod;

public class Server extends Computer { //второй сабкласс
    private String ram;
    private String hdd;
    private String cpu; // характеристики

    public Server(String ram, String hdd, String cpu){ // конструктор
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override // имплементированные методы
    public String getRAM() {
        return this.ram;
    } //Реализация абстрактного метода getRAM() для получения RAM сервера
    @Override
    public String getHDD() {
        return this.hdd;
    } //Реализация абстрактного метода getHDD() для получения RAM сервера
    @Override
    public String getCPU() {
        return this.cpu;
    } //Реализация абстрактного метода getCPU() для получения RAM сервера
}