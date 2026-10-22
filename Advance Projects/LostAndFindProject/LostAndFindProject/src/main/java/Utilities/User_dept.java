package Utilities;

import com.dao.UserDetailsDao;
import com.entity.Department;
import com.entity.UserDetails;

public class User_dept 
{
	public void registerUser()
	{
		Department dept=new Department("IT", "AA");
		UserDetails user=new UserDetails("JJ", "jj@gmail.com", 9876543210l);
		
		user.setDepartment(dept);
		dept.setUser(user);
		
		UserDetailsDao udao=new UserDetailsDao();
		udao.saveUser(user);
		
//		User u = udao.getUserById();
	}
}
