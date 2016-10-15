package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Local
public interface IUserService {

	public void addUserService(User us);
	public void updateUserService(User us);
	public void deleteUserService(User us);
	public List<User> getAllUserService();
	public User getUserByIdService(long id);
	public List<User> getUserByAgentService(Agent a);
	
}
