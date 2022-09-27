import java.util.*;

abstract class Bank {

	static String accno, pin, name, mob, aadhaar, branch, emailid, gender, pincode;
	static String admin, user;
	static int admin_id = 0, admin_password = 2354;
	static String admin_name, admin_age, admin_gender, admin_mobno, admin_branch, admin_mail;
	static Map<Integer, Create_admin_details> store_admin_details = new TreeMap<>();
	static Create_admin_details ad;
	static int user_accno;
	static int user_pin = 0;
	static int choice;
	static String username;

	public static void main(String args[]) {
		display();
	}

	public static void display() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Zoho Bank");

		System.out.println("Choose  Your Option \n 1.Admin\n 2.User");

		int welcome = sc.nextInt();
		int sisu;
		if (welcome > 2) {
			display();
		}
		switch (welcome) {

		case 1:
			System.out.println("1.Signin \n2.Signup");
			sisu = sc.nextInt();
			if (sisu == 1) {
				System.out.println("Enter your Id");
				admin_id = sc.nextInt();
				System.out.println("Enter your Password");
				admin_password = sc.nextInt();
				Admin.login(admin_id, admin_password);
			}
			if (sisu == 2) {
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
			if (sisu == 3) {
				displaylist();
			}
			break;
		case 2:
			System.out.println("1.New User\n2.Existing User");
			int c = sc.nextInt();
			if (c == 1) {
				System.out.println("Enter Your Account number");
				int accno = sc.nextInt();
				System.out.println("Enter Your name");
				String user_name = sc.next();
				System.out.println("Enter Your MobileNo");
				String mobile_no = sc.next();
				User.user_create(username, mobile_no, accno);
			}
			if (c == 2) {
				System.out.println("Enter Your account no");
				user_accno = sc.nextInt();
				System.out.println("Enter Your PIN(4 Digit)");
				user_pin = sc.nextInt();
				User.user_login(user_accno, user_pin);

			}

		}

	}

	private static void displaylist() {
		for (Map.Entry<Integer, Create_admin_details> entry : store_admin_details.entrySet())

		{

			Create_admin_details ad = entry.getValue();
			int key = entry.getKey();
			System.out.println("Account Number:" + key);
			System.out.println("Account Created by ID:" + ad.getAdmin_password());

			System.out.println("Name :" + ad.getAdmin_name());
			System.out.println("Gender: " + ad.getAdmin_gender());

			System.out.println("Email Id: " + ad.getAdmin_mail());

		}

	}

	public static void create_admin(int admin_id, int admin_password, String admin_name, String admin_age,
			String admin_gender, String admin_mail, String admin_mobno, String admin_branch) {
		store_admin_details.put(admin_id, new Create_admin_details(admin_id, admin_password, admin_name, admin_age,
				admin_gender, admin_mail, admin_mobno, admin_branch));
		Create_admin_details cda = store_admin_details.get(admin_id);
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
				Admin.login(admin_id, admin_password);
				choice = false;
			} catch (Exception e) {
				System.out.println("Enter the Input in Integer");
				choice = true;

			}
		}

	}

}
