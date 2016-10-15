package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Stateless
public class UserDaoImpl implements IUserDao{
	
	@PersistenceContext(unitName="PU")
	EntityManager em;

	@Override
	public void addUserDao(User us) {
		em.persist(us);
		
	}

	@Override
	public void updateUserDao(User us) {
		User us2 = em.find(User.class, us.getId_user());
		us2=us;
		em.merge(us2);	
	}

	@Override
	public void deleteUserDao(User us) {
		em.remove(us);
	}

	@Override
	public List<User> getAllUserDao() {
		String req = "SELECT u FROM User";
		Query query = em.createQuery(req);
		@SuppressWarnings("unchecked")
		List<User> liste = query.getResultList();
		return liste;
	}

	@Override
	public User getUserByIdDao(long id) {
		User u = em.find(User.class, id);
		return u;
	}

	@Override
	public List<User> getUserByAgentDao(Agent a) {
		String req = "SELECT * FROM users WHERE agent_id=:id_a";
		Query query = em.createNativeQuery(req, User.class);
		query.setParameter("id_a", a.getId_agent());
		@SuppressWarnings("unchecked")
		List<User> liste = query.getResultList();
		return liste;
	}
	
	
	

	

}
