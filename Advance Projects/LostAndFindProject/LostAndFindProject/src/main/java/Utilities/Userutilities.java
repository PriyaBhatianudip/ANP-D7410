package Utilities;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.UserDao;
import com.entity.User;

public class Userutilities {
	
	UserDao udao;
	Scanner sc;
		public Userutilities()
		{
			sc = new Scanner(System.in);
			udao=new UserDao();
		}
	
		public void registerUser() 
		{
			User user = new User();
			System.out.println("Enter user id : ");
			user.setId(sc.nextInt());
			sc.nextLine();
			System.out.println("enter user name: ");
			user.setName(sc.nextLine());
			System.out.println("enter user phone: ");
			user.setPhone(sc.nextDouble());
			sc.nextLine();
			System.out.println("enter user address: ");
			user.setAddress(sc.nextLine());
			System.out.println("enter user email: ");
			user.setEmail(sc.nextLine());
			System.out.println("enter password: ");
			user.setPassword(sc.nextLine());
			System.out.println("enter user department: ");
			user.setDepartment(sc.nextLine()); 
			
			Object registerUser = udao.registerUser(user);
		}
		
		public void findUser() {
			System.out.println("enter id of user: ");
			int id = sc.nextInt();

			User u = udao.getUser(id);

			if (u != null) {
				System.out.println("user name:" + u.getName() + " || user phone: " + u.getPhone() + " || user address: "
						+ u.getAddress() + " || user email: " + u.getEmail() + " || user department: "
						+ u.getDepartment());
				
				System.out.println("user found!");
			}else {
				System.out.println("user not found");
			}
			

		}
		
		public void getAllUsers() 
		{
			
		}
		
		public int updateUser() {
			System.out.println("enter id of user: ");
			int id = sc.nextInt();
			udao.updateUser(id);
			
			
			return id;
		}
		
		public void deleteUser() {
			System.out.println("enter id of user: ");
			int id = sc.nextInt();
			System.out.println("Calling delete method!!");
			udao.deleteUser(id);
		
		}
}
