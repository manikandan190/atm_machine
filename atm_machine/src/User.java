

public  class User extends Admin{
	
	
	
	public static void user_login(int user_accno,int user_password)
	{	Account_Details ad=mapaccount.get(user_accno);
		if(mapaccount.containsKey(user_accno)&&user_password==ad.getUser_pin())
		{
		
			
			System.out.println("Account Number:"+user_accno);
			System.out.println("Name :"+ad.getName());
			System.out.println("Gender: "+ad.getGender());
			System.out.println("Mobile No: "+ad.getMobileno());
			System.out.println("Email Id: "+ad.getEmailid());
			System.out.println("Branch :"+ad.getBranch());
			System.out.println("Pincode :"+ad.getPincode());
			System.out.println("Bank Name :"+ad.getBank_name());
		    System.out.println("Balance Amount : "+ad.getDeposite());
		    displayacc(user_accno);
			
		}
		else {
			System.out.println("Wrong Pin");
			display();
		}
	}

public  static void displayacc(int user_accno) {
	System.out.println("1.Deposite\n2.Withdraw\n3.Balance\n4.Exit");
    int a=sc.nextInt();
    int amount;
    switch(a) {
    case 1:
    
    	System.out.println("Enter The Amount");
    	 amount=sc.nextInt();
    	deposite(amount,user_accno);
    	break;
    
    
    case 2:
    	System.out.println("Enter The Amount to Withdraw");
    	amount=sc.nextInt();
    	withdraw(amount,user_accno);
    	break;
    	
    
    case 3:
    
    	System.out.println("Account Balance");
    	balance(user_accno);
    	break;
    case 4:
    	display();
    	break;
    	
    }
   
		
	}

	public static void balance(int user_accno) {
		Account_Details ad=mapaccount.get(user_accno);
		ad.setDeposite(ad.getDeposite()+amount);
		mapaccount.put(user_accno,ad);
		System.out.println(ad.getDeposite());
		displayacc(user_accno);
	
	
	
}

	private static void withdraw(int amount, int user_accno) {
		Account_Details ad=mapaccount.get(user_accno);
		if(amount>ad.getDeposite())
		{
			System.out.println("Insufficient Amount");
			displayacc(user_accno);
			
		}
		else {
			ad.setDeposite(ad.getDeposite()-amount);
			mapaccount.put(user_accno, ad);
			displayacc(user_accno);
		}
		
	}

	public static void deposite(int amount,int user_accno) {
		Account_Details ad=mapaccount.get(user_accno);
		ad.setDeposite(ad.getDeposite()+amount);
		mapaccount.put(user_accno,ad);
		displayacc(user_accno);
		
		
		
	}


	public static void user_create(String username, String mobile_no, int accno) {
		
		Account_Details ad=mapaccount.get(accno);
	
		user_pin=user_pin+1023;
		if(mapaccount.containsKey(accno))
		{
			ad.setUser_pin(user_pin);
			
			System.out.println("User Pin:"+ad.getUser_pin());
			mapaccount.put(accno, ad);
			display();
		}
		else {
			System.out.println("User Does not exist");
			display();
		}
		
	}
}