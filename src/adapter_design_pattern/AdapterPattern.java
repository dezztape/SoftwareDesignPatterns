package adapter_design_pattern;

// Определение интерфейса WebDriver с двумя методами
interface WebDriver
{
	public void getElement(); // Метод для получения элемента
	public void selectElement(); // Метод для выбора элемента
}

// Класс ChromeDriver, реализующий интерфейс WebDriver
class ChromeDriver implements WebDriver
{
	@Override
	public void getElement()
	{
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement()
	{
		System.out.println("Select element from ChromeDriver");
	}
}

// Класс IEDriver с собственными методами для работы с IE
class IEDriver
{
	public void findElement()
	{
		System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
		System.out.println("Click element from IEDriver");
	}
}

// Класс WebDriverAdapter, адаптирующий IEDriver под интерфейс WebDriver
class WebDriverAdapter implements WebDriver
{
	IEDriver ieDriver;
	public WebDriverAdapter(IEDriver ieDriver)
	{
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement()
	{
		ieDriver.findElement(); // Адаптация для получения элемента
	}

	@Override
	public void selectElement()
	{
		ieDriver.clickElement(); // Адаптация для выбора элемента
	}
}

public class AdapterPattern
{
	public static void main(String[] args)
	{
		// Создание и использование объекта ChromeDriver
		ChromeDriver a = new ChromeDriver();
		a.getElement(); // Получение элемента
		a.selectElement(); // Выбор элемента

		// Создание и использование объекта IEDriver
		IEDriver e = new IEDriver();
		e.findElement(); // Поиск элемента
		e.clickElement(); // Нажатие элемента

		// Создание и использование адаптера для IEDriver
		WebDriver wID = new WebDriverAdapter(e);
		wID.getElement(); // Получение элемента
		wID.selectElement(); // Выбор элемента
	}
}
