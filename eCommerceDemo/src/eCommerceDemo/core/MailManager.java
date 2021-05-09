package eCommerceDemo.core;

import eCommerceDemo.entities.concretes.User;

public class MailManager implements MailService {

String verifyCode;
	
	@Override
	public String toProduceCode(User user) {
		 this.verifyCode = String.valueOf(user.getId())+user.getPassword();
		 return verifyCode;	
	}

	@Override
	public void sendMail(User user) {
		
		System.out.println(user.getFirstName() +" "+user.getLastName()+
				" adl� ki�iye e-mail g�nderildi.\n"+ verifyCode);
		
		
	}

	@Override
	public boolean certifyCode(String code) {
		
		if(this.userCheck()) {
			if(this.verifyCode ==code) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}

	@Override
	public boolean userCheck() {
		//kullan�c�n�n mail linkine t�klamas�n� kontrol eder
		return true;
	}

}
