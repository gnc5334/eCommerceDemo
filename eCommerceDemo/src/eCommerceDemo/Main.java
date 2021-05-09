package eCommerceDemo;

import eCommerceDemo.business.abstracts.AuthService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.AuthManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.MailManager;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user = new User(1,"Gonca Gül","Kazancý","a@gmailcom","123456");
		UserService userManager = new UserManager(new HibernateUserDao());
		AuthService authManager = new AuthManager(userManager,new MailManager());
		
		
		authManager.register(user);
		
		//authManager.login("a@gmailcom","123456");

	}

}
