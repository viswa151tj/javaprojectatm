package bankProcess;
import java.io.*;
public class createAccount {
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
