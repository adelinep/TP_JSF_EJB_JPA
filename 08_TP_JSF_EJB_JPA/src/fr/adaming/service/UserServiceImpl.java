package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Stateless
public class UserServiceImpl implements IUserService {

	@EJB
	IUserService userService;
	
	@Override
	public void addUserService(User us) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserService(User us) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserService(User us) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUserService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByIdService(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByAgentService(Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

}
