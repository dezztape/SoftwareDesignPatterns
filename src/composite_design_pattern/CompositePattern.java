package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Абстрактный класс Account, представляющий базовую сущность для всех видов счетов
abstract class Account
{
  public abstract float getBalance();
}

// Класс DepositeAccount, наследуется от Account, представляет депозитный счет
class DepositeAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance)
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}

// Класс SavingAccount, наследуется от Account, представляет сберегательный счет
class SavingAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance)
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}

// Класс CompositeAccount, наследуется от Account, представляет составной счет
class CompositeAccount extends Account
{
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance()
  {
    totalBalance = 0;
    for (Account account : accountList)
    {
      totalBalance = totalBalance + account.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account account)
  {
    accountList.add(account);
  }

  public void removeAccount(Account account)
  {
    accountList.add(account);
  }
}

public class CompositePattern
{
  public static void main(String[] args)
  {
    // Создание CompositeAccount (составной счет)
    CompositeAccount compositeAccount = new CompositeAccount();

    // Добавление депозитных и сберегательных счетов в составной счет
    compositeAccount.addAccount(new DepositeAccount("DA001", 100));
    compositeAccount.addAccount(new DepositeAccount("DA002", 150));
    compositeAccount.addAccount(new SavingAccount("SA001", 200));

    // Получение общего баланса составного счета
    float totalBalance = compositeAccount.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
