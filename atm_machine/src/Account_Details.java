
public class Account_Details {
	private int user_accno;
	
	private int admin_id;
	private  String name;
	private String gender;
	private String mobileno;
	private  String emailid;
	private String branch;
	private  String pincode;
	private  int deposite;
	private String bank_name;
	private String admin_name;
	private int Balance=0;
	private int user_pin;
	public   Account_Details (int user_accno,String name,String gender,String mobileno,String emailid,String branch,String pincode,int deposite,String bank_name,int admin_id,String admin_name,int user_pin)
	{
		this.user_accno=user_accno;
		this.name=name;
		this.gender=gender;
		this.mobileno=mobileno;
		this.emailid=emailid;
		this.branch=branch;
		this.pincode=pincode;
		this.deposite=deposite;
		this.bank_name=bank_name;
		this.admin_id=admin_id;
		this.admin_name=admin_name;
		this.user_pin=user_pin;
	}
	public void setUser_pin(int user_pin)
	{
		this.user_pin=user_pin;
	}
	public int getUser_pin()
	{
		return user_pin;
	}
	
	
	public String getAdmin_name()
	{
		return admin_name;
	}
	public void setAdmin_name(String admin_name)
	{
		this.admin_name=admin_name;
	}
	public int getAdmin_id()
	{
		return admin_id;
	}
	public void setAdmin_id(int admin_id)
	{
		this.admin_id=admin_id;
	}
	public String getBank_name()
	{
		return bank_name;
	}
	public void setDeposite(int deposite)
	{
		this.deposite=deposite;
	}
	public int getDeposite()
	{
		return deposite;
	}
	public void setPincode(String pincode)
	{
		this.pincode=pincode;
	}
	public String getPincode()
	{
		return pincode;
	}
	public void setBranch(String branch)
	{
		this.branch=branch;
	}
	public String getBranch()
	{
		return branch;
	}
	public void setEmailid(String emailid)
	
	{
		this.emailid=emailid;
	}
	public String getEmailid()
	{
		return emailid;
	}
	public void setMobileno(String mobileno)
	{
		this.mobileno=mobileno;
	}
	public String getMobileno()
	{
		return mobileno;
	}
	public void setName(String change_name)
	{
		this.name = change_name;
	
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getName()
	{
		return name;
	}
	public  String getGender()
	{
		return gender;
	}
	
	public  void setUser_accno(int user_accno) {
		this.user_accno = user_accno;

		
	}
	public   int getUser_accno() {
		return user_accno;
	}

  

}

