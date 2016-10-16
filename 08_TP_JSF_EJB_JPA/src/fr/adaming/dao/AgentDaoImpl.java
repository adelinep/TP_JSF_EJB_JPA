package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.adaming.model.Agent;

@Stateless				
public class AgentDaoImpl implements IAgentDao{
	
	@PersistenceContext(unitName="PU")
	EntityManager em;

	@Override
	public List<Agent> isExistDao(String login, String password) {
		
		
		String req = "SELECT a from Agent a WHERE a.login=:log AND a.password=:pass";
		Query reqQue = em.createQuery(req);
		reqQue.setParameter("log", login);
		reqQue.setParameter("pass", password);
		
		@SuppressWarnings("unchecked")
		List<Agent> listAgent=reqQue.getResultList();
		
		return listAgent;
		
		
	}

}
