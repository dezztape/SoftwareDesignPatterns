package AbstractFactoryMethod;

public class PC extends Computer { // первый саб класс
    private String ram;
    private String hdd;
    private String cpu; // значение RAM HDD CPU

    public PC(String ram, String hdd, String cpu){ // инициализация наших переменных
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    } // получени RAM для класса PC
    @Override
    public String getHDD() {
        return this.hdd;
    } // получени HDD для класса PC
    @Override
    public String getCPU() {
        return this.cpu;
    } // получени CPU для класса PC
}