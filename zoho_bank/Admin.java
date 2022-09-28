package zoho_bank;
import java.util.*;

class Admin extends Main {
	


private String admin_name,admin_age,admin_gender,admin_mail,admin_mobno,admin_branch;
private int admin_id,admin_password;
public void display(int choice)
{ 
	Scanner sc=new Scanner(System.in);
	System.out.println("1.Sigin\t2.Signup");
	System.out.println();
	System.out.println("Enter your choice");
	choice=sc.nextInt();
	if(choice==1)
	{
		System.out.println("Enter your Id");
		admin_id = sc.nextInt();
		System.out.println("Enter your Password");
		admin_password = sc.nextInt();
		login(admin_id, admin_password);
		
		
	}
	if(choice==2)
	{
		admin_id += 10;
		admin_password += 45;
		System.out.println("Enter your Name");
		admin_name = sc.next();
		System.out.println("Enter Your age");
		admin_age = sc.next();
		System.out.println("Enter Your gender");
		admin_gender = sc.next();
		System.out.println("Enter Your mail");
		admin_mail = sc.next();
		System.out.println("Enter your mobile No");

		admin_mobno = sc.next();

		System.out.println("Enter your Branch");
		admin_branch = sc.next();
		create_admin(admin_id, admin_password, admin_name, admin_age, admin_gender, admin_mail, admin_mobno,
				admin_branch);
	}
}
	




public static void create_admin(int admin_id, int admin_password, String admin_name, String admin_age,
		String admin_gender, String admin_mail, String admin_mobno, String admin_branch) {
	store_admin_details.put(admin_id, new database(admin_id, admin_password, admin_name, admin_age,
			admin_gender, admin_mail, admin_mobno, admin_branch));
	database cda = store_admin_details.get(admin_id);
	System.out.println("Admin id:" + cda.getAdmin_id());
	System.out.println("Admin password: " + cda.getAdmin_password());
	System.out.println("Admin Created Successfully");
	System.out.println("================================================");
	System.out.println("Login");
	boolean choice = true;
	while (choice) {
		try {
			System.out.println("Enter admin_id");
			Scanner sc = new Scanner(System.in);
			admin_id = sc.nextInt();
			System.out.println("Enter admin_password");
			admin_password = sc.nextInt();
			login(admin_id, admin_password);
			choice = false;
		} catch (Exception e) {
			System.out.println("Enter the Input in Integer");
			choice = true;

		}
	}

}







public static void login(int admin_id, int admin_password) {
	Scanner sc=new Scanner(System.in);
	int accno,deleteaccno;
	boolean check=true;
	int user_acc=0;
	database cda=store_admin_details.get(admin_id);
	System.out.println(cda.getAdmin_id());
     
	if(store_admin_details.containsKey(admin_id)&&cda.getAdmin_password()==(admin_password))
		
	{
		
		

	while(check)	
	{
		    user_acc+=1;
			System.out.println("1.Create Account\n2.Delete Account \n3.Update Account \n4.List Account \n5.Account Details \n6.Search Name \n7.LogOut ");
			System.out.println();
			System.out.println("Enter Your Choice");
			
			int choice=sc.nextInt();
			System.out.println("================================================");
			switch(choice)
			{
			case 1:
			     createaccountdetails(admin_id,user_acc);
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
			    
				
				break;
			
			}}
	}
	else {
		System.out.println("Create an account");
	}
		}
	public static void search_name() {
		String name;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		name=sc.next();

		search_name.entrySet().stream().filter(map -> map.getValue().startsWith(name))
	    .forEach(m -> viewaccount(m.getKey()));
		
		
	}
	public static void viewaccount(int accno) {
		Scanner sc=new Scanner(System.in);
		
		database ad=mapaccount.get(accno);
		
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
	public static  void createaccountdetails(int a_id,int user_accno) {
		int deposite,user_pin=0;
		
		String bank_name="ZOHO  Bank";
		String name,gender,mobileno,emailid,branch,pincode;
		Scanner sc=new Scanner(System.in);
	
		
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
	   database cda=store_admin_details.get(a_id);
	   createaccount(user_accno,name,gender,mobileno,emailid,branch,pincode,deposite,bank_name,cda.getAdmin_id(),cda.getAdmin_name(),user_pin);
	   
		
	}
	public  static void update() {
	   database ad;
	   int accno;
	   
	   String change_name,change_gender,change_mobileno,change_emailid,change_pincode,change_branch;
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter your Account Number");
		accno=sc.nextInt();
		System.out.println("================================================");
		if(mapaccount.containsKey(accno))
		{
		System.out.println("To update Enter your choice");
		System.out.println("1.Name\n2.Gender\n3.Mobile No\n4.Email Id \n5.Pincode\n 6.Branch");
		 int update_choice=sc.nextInt();
		switch(update_choice)
		{
		case 1:
			System.out.println("Enter The Name");
			change_name=sc.next();
			 ad=mapaccount.get(accno);
			ad.setName(change_name);
			mapaccount.put(accno, mapaccount.getOrDefault(accno, ad));
			search_name.put(accno, ad.getName());
			
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
		for(Map.Entry<Integer,database> entry:mapaccount.entrySet())
			
		{
		database ad=entry.getValue();
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
		
		mapaccount.put(user_accno,new  database(user_accno,name,gender,mobileno,emailid,branch,pincode,deposite,bank_name,admin_id,admin_name,user_pin));
		
		
	}

	

}















