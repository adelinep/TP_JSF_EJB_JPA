package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import fr.adaming.dao.IUserDao;
import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Stateful
public class UserServiceImpl implements IUserService {

	@EJB
	IUserDao userDao;
	
	@Override
	public void addUserService(User us) {
		userDao.addUserDao(us);
	}

	@Override
	public void updateUserService(User us) {
		userDao.updateUserDao(us);
	}

	@Override
	public void deleteUserService(User us) {
		userDao.deleteUserDao(us);
	}

	@Override
	public List<User> getAllUserService() {
		return userDao.getAllUserDao();
	}

	@Override
	public User getUserByIdService(long id) {
		return userDao.getUserByIdDao(id);
	}

	@Override
	public List<User> getUserByAgentService(Agent a) {
		return userDao.getUserByAgentDao(a);
	}

}
