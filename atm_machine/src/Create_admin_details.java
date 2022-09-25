
public class Create_admin_details {
	private String admin_name,admin_age,admin_gender,admin_mail,admin_mobno,admin_branch;
	private int admin_id,admin_password;
public Create_admin_details(int admin_id,int admin_password,String admin_name,String admin_age,String admin_gender,String admin_mail,String admin_mobno,String admin_branch)
{
	this.admin_id=admin_id;
	this.admin_name=admin_name;
	this.admin_age=admin_age;
	this.admin_gender=admin_gender;
	this.admin_mail=admin_mail;
	this.admin_mobno=admin_mobno;
	this.admin_branch=admin_branch;
	this.admin_password=admin_password;
	
}

public int getAdmin_password() {
	return admin_password;
}
public void setAdmin_password(int admin_password)
{
	this.admin_password=admin_password;
}
public String getAdmin_branch()
{
	return admin_branch;
}
public void setAdmin_mobno(String admin_mobno)
{
	this.admin_mobno=admin_mobno;
}
public String getAdmin_mail() {
	return admin_mail;
}
public void setAdmin_mail()
{
	this.admin_mail=admin_mail;
}
public String getAdmin_gender()
{
	return admin_gender;
}
public void setAdmin_gender(String admin_gender)
{
	this.admin_gender=admin_gender;
}
public  String getAdmin_age()
{
	return admin_age;
}
public void setAdmin_age(String admin_age)
{
	this.admin_age=admin_age;
}

public String getAdmin_name()
{
	return admin_name;
}
public void setAdmin_name(String admin_name)
{
	this.admin_name=admin_name;
}
public void setAdmin_id(int admin_id)
{
	this.admin_id=admin_id;
}
public int getAdmin_id()
{
	return admin_id;
}



}
