package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Stateless
public class UserDaoImpl implements IUserDao{
	
	@PersistenceContext(unitName="PU")
	EntityManager em;

	@Override
	public void ajouter(User us) {
		em.persist(us);
		
	}

	@Override
	public void update(User us) {
		User us2 = em.find(User.class, us.getId_user());
		us2=us;
		em.merge(us2);	
	}

	@Override
	public void supprimerDao(User us) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getByAgent(Agent a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	

}
