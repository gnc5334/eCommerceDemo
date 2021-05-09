package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		for(User member:users) {
			if(member.getId()==user.getId()) {
				member.setFirstName(user.getFirstName());
				member.setLastName(user.getLastName());
				member.setEmail(user.getEmail());
				member.setPassword(user.getPassword());
			}
		}
		
	}

	@Override
	public void delete(User user) {
		users.remove(user.getId());
	}

	@Override
	public User get(int id) {
		User user = new User();
		for(User getUser: users) {
			if(getUser.getId()==id) {
				user= getUser;
			}
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

}
