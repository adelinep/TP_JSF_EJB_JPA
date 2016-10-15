package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

public interface IUserDao {
	public void addUserDao(User us);
	public void updateUserDao(User us);
	public void deleteUserDao(User us);
	public List<User> getAllUserDao();
	public User getUserByIdDao(long id);
	public List<User> getUserByAgentDao(Agent a);
}
