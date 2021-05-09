package eCommerceDemo.core;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.entities.concretes.User;

public class Controls {
	
public static boolean checkPassword(String password) {
		
		if(password.length()<6) {
			System.out.println("�ifre en az 6 karakter olmal�d�r.");
			return false;
		}else {
			return true;
		}
		
	}
	
	
	public static boolean checkEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			return true;
		}else {
			
			return false;
		}
	}
	
	
	public static boolean checkName(String name) {
		if(name.length()<2) {
			System.out.println("En az iki karakter olmal�d�r.");
			return false;
		}else {
			return true;
		}
	}
	
	
	public static boolean checkUserExists(List<User> users, String email) {
		
		for(User user:users) {
			if (user.getEmail() == email) 				
				return true;
		}
		return false;
	}
	
	public static boolean checkUserPassword(List<User> users, String password) {
			
			for(User user:users) {
				if (user.getPassword() == password) 
					return true;
			}
			return false;
		}


}
