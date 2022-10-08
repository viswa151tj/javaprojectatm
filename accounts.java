package bankProcess;
import java.io.*;
public class accounts implements Serializable {
	public int account_no;
	public String account_holder;
	private int pin;
	private int account_balance;
	accounts(int num,String name,int p,int bal)
	{
		this.account_no=num;
		this.account_holder=name;
		this.account_balance=bal;
		this.pin=p;
	}
	int getBalance(int p)
	{
		if (p==this.pin)
			return account_balance;
		else
			return -1;
	}
	boolean validate_pin(int p)
	{
		if(p==this.pin)
				return true;
		else
			return false;
	}
	void addMoney(int value,int p)
	{
		if(p==this.pin)
			this.account_balance+=value;
	}
	void deductMoney(int value, int p)
	{
		if(p==this.pin)
			this.account_balance-=value;
	}
	public static void main(String args[])
	{
		accounts obj[]= new accounts[5];
		obj[0]=new accounts(101,"Suresh",2343,25234);
		obj[1]=new accounts(102,"Ganesh",5432,34123);
		obj[2]=new accounts(103,"Magesh",7854,26100);
		obj[3]=new accounts(104,"Naresh",2345,80000);
		obj[4]=new accounts(105,"Harish",1907,103400);
		try{
		FileOutputStream file= new FileOutputStream("acc_info.ser");
		ObjectOutputStream out=new ObjectOutputStream(file);
		out.writeObject(obj);
		out.close();
		file.close();
		System.out.println("Serialized data of the accounts are stored in acc_info.ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}
}
