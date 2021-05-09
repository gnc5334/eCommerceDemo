package eCommerceDemo.core;

import eCommerceDemo.business.abstracts.AuthService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.entities.concretes.User;
import eCommerceDemo.jGoogle.jGoogleManager;

public class jGoogleManagerAdapter implements AuthService {

	private UserService userService;

	public jGoogleManagerAdapter(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void login(String email, String password) {
		if (!Controls.checkUserExists(userService.getAll(),email)) {
			if(Controls.checkUserPassword(userService.getAll(),password)) {
				System.out.println("Sisteme giris yapildi.");			
				return;
			}
		}
		System.out.println("E-mail sisteme kayitli degil. Lütfen önce sisteme kayit olun.");
		
		
	}

	@Override
	public void register(User user) {
		
		if(Controls.checkUserExists(userService.getAll(),user.getEmail())) {
			if(Controls.checkName(user.getFirstName())) {
				if(Controls.checkEmail(user.getEmail())) {
					if(Controls.checkPassword(user.getPassword())) {
						jGoogleManager googleManager = new jGoogleManager();
						googleManager.registerWithGoogle(user);
					}
				}
			}
		}else {
			System.out.println("Kaydýnýz zaten mevcuttur.");
		}
		
	}



}
