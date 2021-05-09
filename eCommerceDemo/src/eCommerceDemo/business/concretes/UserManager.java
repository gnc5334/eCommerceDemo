package eCommerceDemo.business.concretes;

import java.util.List;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("Kayýt baþarýlý.");
		
	}


	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User getById(int id) {		
		return userDao.get(id);
	}

	@Override
	public User getByMail(String email) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
