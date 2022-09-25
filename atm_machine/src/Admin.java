import java.util.Collection;
import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Admin extends Bank {
static	Scanner sc=new Scanner(System.in);
static Map<Integer,Account_Details> mapaccount=new HashMap<>();
static String name,mobileno,emailid,branch,pincode,gender;
static int user_accno=0;
static int amount=0;
static int deleteaccno;
static int deposite;
static String bank_name="ZOHO BANK";
static  int accno;
static int update_choice;
static String change_name;
static String change_gender;
static String change_mobileno;
static String change_emailid;
static String change_pincode;
static String change_branch;
static int a_id;
static int user_pin;
public static void login(int admin_id,int admin_password)
{Scanner sc=new Scanner(System.in);
a_id=admin_id;
boolean check=true;
Create_admin_details cda=store_admin_details.get(admin_id);
System.out.println(cda.getAdmin_id());
System.out.println(cda.getAdmin_password());

if(Bank.store_admin_details.containsKey(admin_id)&&cda.getAdmin_password()==(admin_password))
	
{
	
	

while(check)	
{
		System.out.println("1.Create Account\n 2.Delete Account \n 3.Update Account \n4.List Account \n5.Account Details \n 6.Continue \n 7.LogOut ");
		System.out.println("Enter Your Choice");
		
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		     createaccountdetails();
		     System.out.println("Account Created succussfully");
		    break;
		case 2:
			System.out.println("Enter the account number");
			deleteaccno=sc.nextInt();
			deleteaccount(deleteaccno);
			System.out.println("Account number deleted successfully.");
			break;
		case 3:
			update();
			
			break;
			
		case 4:
			printAccount_Details();
		    break;
		case 5:
			viewaccount();
			break;
		case 6:
			break;
		case 7:
			System.out.println("Logout Successfully");
			check=false;
			Bank.display();
			
			break;
		
		}}
}
else {
	System.out.println("Create an account");
	Bank.display();
}
	}
public static void viewaccount() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Account Number");
	accno=sc.nextInt();
	Account_Details ad=mapaccount.get(accno);
	
	System.out.println("Account Number:"+accno);
	System.out.println("Name :"+ad.getName());
	System.out.println("Gender: "+ad.getGender());
	System.out.println("Mobile No: "+ad.getMobileno());
	System.out.println("Email Id: "+ad.getEmailid());
	System.out.println("Branch :"+ad.getBranch());
	System.out.println("Pincode :"+ad.getPincode());
	System.out.println("Bank Name :"+ad.getBank_name());
    System.out.println("Balance Amount : "+ad.getDeposite());
	
}
public static void createaccountdetails() {
	Scanner sc=new Scanner(System.in);
	user_accno=user_accno+1;
	
	System.out.println("Enter your name");
	
	name=sc.next();
	System.out.println("Enter your gender");
    gender=sc.next();


    System.out.println("Enter Your mobileno");
    mobileno=sc.next();
    System.out.println("Enter Your emailid");
    emailid=sc.next();
    System.out.println("Enter Your branch");
    branch=sc.next();
    System.out.println("Enter your pincode");
    pincode=sc.next();
    System.out.println("Enter your Amount to  deposite");
    deposite = sc.nextInt();
   Create_admin_details cda=store_admin_details.get(a_id);
	
    createaccount(user_accno,name,gender,mobileno,emailid,branch,pincode,deposite,bank_name,cda.getAdmin_id(),cda.getAdmin_name(),user_pin);
	
}
public  static void update() {
	Account_Details ad;
	Scanner sc=new Scanner (System.in);
	System.out.println("Enter your Account Number");
	accno=sc.nextInt();
	
	if(mapaccount.containsKey(accno))
	{
	System.out.println("To update Enter your choice");
	System.out.println("1.Name\n2.Gender\n3.Mobile No\n4.Email Id \n5.Pincode\n 6.Branch");
	update_choice=sc.nextInt();
	switch(update_choice)
	{
	case 1:
		System.out.println("Enter The Name");
		change_name=sc.next();
		 ad=mapaccount.get(accno);
		ad.setName(change_name);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
		break;
	case 2:
		System.out.println("Enter The Gender");
		change_gender=sc.next();
		 ad=mapaccount.get(accno);
		ad.setGender(change_gender);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
		break;
	case 3:
		System.out.println("Enter The Mobile No");
		change_mobileno=sc.next();
		ad=mapaccount.get(accno);
		ad.setMobileno(change_mobileno);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
		break;
	case 4:
		System.out.println("Enter The Email Id");
		change_emailid=sc.next();
		ad=mapaccount.get(accno);
		ad.setMobileno(change_emailid);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
		break;
	case 5:
		System.out.println("Enter The Pincode");
		change_pincode=sc.next();
		ad=mapaccount.get(accno);
		ad.setMobileno(change_pincode);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
		break;
	case 6:
		System.out.println("Enter The Branch");
		change_branch=sc.next();
		ad=mapaccount.get(accno);
		ad.setBranch(change_branch);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
		break;
	
		
	}
	
	System.out.println("Account Updated succussfully");
	}
	
	else {
		System.out.println("Account Does not Exist");
	}
	
}
public static void deleteaccount(int deleteaccno) {
	mapaccount.remove(deleteaccno);
	
}
public static void printAccount_Details() {
	for(Map.Entry<Integer,Account_Details> entry:mapaccount.entrySet())
		
	{
	Account_Details ad=entry.getValue();
		int key=entry.getKey();
		System.out.println("Account Number:"+key);
		System.out.println("Account Created by ID:"+ad.getAdmin_id()+"    Name:"+ad.getAdmin_name());
		
		System.out.println("Name :"+ad.getName());
		System.out.println("Gender: "+ad.getGender());
		System.out.println("Mobile No: "+ad.getMobileno());
		System.out.println("Email Id: "+ad.getEmailid());
		System.out.println("Branch :"+ad.getBranch());
		System.out.println("Pincode :"+ad.getPincode());
		System.out.println("Bank Name :"+ad.getBank_name());
	    System.out.println("Balance Amount : "+ad.getDeposite());
	    
	}
	
	
}
public static void createaccount(int user_accno,String name,String gender,String mobileno,String emailid,String branch,String pincode,int deposite,String bank_name,int admin_id,String admin_name,int user_pin) {
	
	mapaccount.put(user_accno,new  Account_Details(user_accno,name,gender,mobileno,emailid,branch,pincode,deposite,bank_name,admin_id,admin_name,user_pin));
	
	
}


}

