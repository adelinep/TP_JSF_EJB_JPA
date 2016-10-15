package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

public interface IUserDao {
	public void ajouter(User us);
	public void update(User us);
	public void supprimerDao(User us);
	public List<User> getAllUserDao();
	public User getById(long id);
	public List<User> getByAgent(Agent a);
}
