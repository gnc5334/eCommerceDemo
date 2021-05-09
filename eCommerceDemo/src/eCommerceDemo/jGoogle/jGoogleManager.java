package eCommerceDemo.jGoogle;

import eCommerceDemo.entities.concretes.User;

public class jGoogleManager {

	public void registerWithGoogle(User user)
	{
		System.out.println("Google ile giriþ: " + user.getLastName());
	}
}
