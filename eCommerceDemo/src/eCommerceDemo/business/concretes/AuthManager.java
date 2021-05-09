package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.AuthService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.Controls;
import eCommerceDemo.core.MailService;
import eCommerceDemo.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	private MailService senderService;
	
	public AuthManager(UserService userService,MailService senderService) {
		super();
		this.userService = userService;
		this.senderService=senderService;
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
		
		if(!Controls.checkUserExists(userService.getAll(),user.getEmail())) {
			if(Controls.checkName(user.getFirstName())) {
				if(Controls.checkEmail(user.getEmail())) {
					if(Controls.checkPassword(user.getPassword())) {
						String code= senderService.toProduceCode(user);
						senderService.sendMail(user);
						if(senderService.certifyCode(code)) {
							userService.add(user);
						}
						
					}
				}
				else {
					System.out.println("E-mail adresinizi lütfen doðru giriniz.");
				}
					
			}
		}else {
			System.out.println("Kaydýnýz zaten mevcuttur.");
		}
		
		
					
	}


}
