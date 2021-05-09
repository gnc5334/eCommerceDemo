package eCommerceDemo.core;

import eCommerceDemo.entities.concretes.User;

public interface MailService {

	String toProduceCode(User user);
	void sendMail(User user);
	boolean certifyCode(String code);
	boolean userCheck();
}
