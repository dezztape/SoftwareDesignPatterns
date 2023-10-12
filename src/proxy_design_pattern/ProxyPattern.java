package proxy_design_pattern;

// Интерфейс DatabaseExecuter определяет метод для выполнения запросов к базе данных
interface DatabaseExecuter
{
	public void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl реализует интерфейс DatabaseExecuter и представляет реального исполнителя
class DatabaseExecuterImpl implements DatabaseExecuter
{
	@Override
	public void executeDatabase(String query) throws Exception
	{
		System.out.println("Going to execute Query: " + query);
	}
}

// Класс DatabaseExecuterProxy реализует интерфейс DatabaseExecuter и представляет прокси для выполнения запросов
class DatabaseExecuterProxy implements DatabaseExecuter
{
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd)
	{
		if(name == "Admin" && passwd == "Admin@123")
		{
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception
	{
		if(ifAdmin)
		{
			dbExecuter.executeDatabase(query);
		}
		else
		{
			if(query.equals("DELETE"))
			{
				throw new Exception("DELETE not allowed for non-admin user");
			}
			else
			{
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern
{
	public static void main(String[] args) throws Exception
	{
		// Создание прокси для неадминистратора и попытка выполнения запросов
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Опечатка, должно быть "DELETE"

		// Создание прокси для неадминистратора и попытка выполнения DELETE-запроса
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		// Создание прокси для администратора и выполнение DELETE-запроса
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
