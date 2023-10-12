package decorator_design_pattern;

// Интерфейс Dress, представляющий одежду и определяющий метод assemble
interface Dress
{
	public void assemble();
}

// Базовый класс BasicDress, реализующий интерфейс Dress
class BasicDress implements Dress
{
	@Override
	public void assemble()
	{
		System.out.println("Basic Dress Features");
	}
}

// Класс DressDecorator, является декоратором для Dress
class DressDecorator implements Dress
{
	protected Dress dress;
	public DressDecorator(Dress c)
	{
		this.dress = c;
	}

	@Override
	public void assemble()
	{
		this.dress.assemble();
	}
}

// Класс CasualDress, является конкретным декоратором для добавления "Casual" функциональности
class CasualDress extends DressDecorator
{
	public CasualDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// Класс SportyDress, является конкретным декоратором для добавления "Sporty" функциональности
class SportyDress extends DressDecorator
{
	public SportyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// Класс FancyDress, является конкретным декоратором для добавления "Fancy" функциональности
class FancyDress extends DressDecorator
{
	public FancyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

public class DecoratorPattern
{
	public static void main(String[] args)
	{
		// Создание различных комбинаций одежды с помощью декораторов
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
