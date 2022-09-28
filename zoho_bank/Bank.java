package zoho_bank;
import java.util.*;

interface Bank {
	public void display();

	}
abstract class Display_Bank_Details extends store_bank_details implements Bank{

 public void Bank_Details() { 
	 System.out.println("Bank Name : "+name);
	 System.out.println("Bank Ifsc : "+ifsc);
	 System.out.println("Bank Address : "+address);
	 System.out.println("Bank Pincode : "+pincode);
	 System.out.println("Bank State : "+state);
	 System.out.println("Bank Branch : "+branch);
	 
 }
}
class Main{
	static Map<Integer,String> search_name=new TreeMap<>();
	static Map<Integer,database> mapaccount=new TreeMap<>();
	static Map<Integer, database> store_admin_details = new TreeMap<>();
	public static void main(String args[])
	{
		Admin a=new Admin();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome To Zoho Bank");
		System.out.println();
		
		try {
		System.out.println("1.Admin\t 2.User");
		System.out.println();
		System.out.println("Enter Your choice");
		int send=sc.nextInt();
		
		a.display(send);
		
		sc.close();
		}
		catch(Exception e)
		{
			System.out.println("Enter The Choice in Integer");
			
		}
		
		
		
		
		
	}
}
