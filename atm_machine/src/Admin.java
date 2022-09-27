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
static Map<Integer,String> search_name=new TreeMap<>();
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
		System.out.println("1.Create Account\n2.Delete Account \n3.Update Account \n4.List Account \n5.Account Details \n6.Search Name \n7.LogOut ");
		System.out.println();
		System.out.println("Enter Your Choice");
		
		int choice=sc.nextInt();
		System.out.println("================================================");
		switch(choice)
		{
		case 1:
		     createaccountdetails();
		     System.out.println("Account Created succussfully");
		     System.out.println("================================================");
		    break;
		case 2:
			System.out.println("Enter the account number");
			deleteaccno=sc.nextInt();
			deleteaccount(deleteaccno);
			System.out.println("Account number deleted successfully.");
		     System.out.println("================================================");
			break;
		case 3:
			update();
			
			break;
			
		case 4:
			printAccount_Details();
		    break;
		case 5:
			System.out.println("Enter the Account Number");
			accno=sc.nextInt();
			System.out.println("================================================");
			viewaccount(accno);
		     
			break;
		case 6:
			search_name();
			break;
		case 7:
			System.out.println("Logout Successfully");
		     System.out.println("================================================");
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
public static void search_name() {
	System.out.println("Enter the name");
	name=sc.next();
	
//	List<String> valueList = search_name.values().stream()
//			.filter(n->n.startsWith(name))
//			.collect(Collectors.toList());

//	System.out.println("Names" + valueList);
	search_name.entrySet().stream().filter(map -> map.getValue().startsWith(name))
    .forEach(m -> viewaccount(m.getKey()));
	
	
}
public static void viewaccount(int accno) {
	Scanner sc=new Scanner(System.in);
	
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
    System.out.println("================================================");
	
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
    search_name.put(user_accno,name);
    System.out.println("================================================");
   Create_admin_details cda=store_admin_details.get(a_id);
	
    createaccount(user_accno,name,gender,mobileno,emailid,branch,pincode,deposite,bank_name,cda.getAdmin_id(),cda.getAdmin_name(),user_pin);
	
}
public  static void update() {
	Account_Details ad;
	Scanner sc=new Scanner (System.in);
	System.out.println("Enter your Account Number");
	accno=sc.nextInt();
	System.out.println("================================================");
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
		search_name.put(accno, ad.getName());
		System.out.println(search_name);
	     System.out.println("================================================");
		break;
	case 2:
		System.out.println("Enter The Gender");
		change_gender=sc.next();
		 ad=mapaccount.get(accno);
		ad.setGender(change_gender);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
	     System.out.println("================================================");
		break;
	case 3:
		System.out.println("Enter The Mobile No");
		change_mobileno=sc.next();
		ad=mapaccount.get(accno);
		ad.setMobileno(change_mobileno);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
	     System.out.println("================================================");
		break;
	case 4:
		System.out.println("Enter The Email Id");
		change_emailid=sc.next();
		ad=mapaccount.get(accno);
		ad.setMobileno(change_emailid);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
	     System.out.println("================================================");
		break;
	case 5:
		System.out.println("Enter The Pincode");
		change_pincode=sc.next();
		ad=mapaccount.get(accno);
		ad.setMobileno(change_pincode);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
	     System.out.println("================================================");
		break;
	case 6:
		System.out.println("Enter The Branch");
		change_branch=sc.next();
		ad=mapaccount.get(accno);
		ad.setBranch(change_branch);
		mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
	     System.out.println("================================================");
		break;
	
		
	}
	
	System.out.println("Account Updated succussfully");
    System.out.println("================================================");
	}
	
	else {
		System.out.println("Account Does not Exist");
		System.out.println("================================================");
	}
	
}
public static void deleteaccount(int deleteaccno) {
	mapaccount.remove(deleteaccno);
	search_name.remove(deleteaccno);
	
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
	     System.out.println("================================================");
	    
	}
	
	
}
public static void createaccount(int user_accno,String name,String gender,String mobileno,String emailid,String branch,String pincode,int deposite,String bank_name,int admin_id,String admin_name,int user_pin) {
	
	mapaccount.put(user_accno,new  Account_Details(user_accno,name,gender,mobileno,emailid,branch,pincode,deposite,bank_name,admin_id,admin_name,user_pin));
	
	
}


}

