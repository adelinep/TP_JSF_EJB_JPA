package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

@Stateless
public class AgentServiceImpl implements IAgentService{

	@EJB
	IAgentDao agentDao;
	@Override
	public List<Agent> isExistService(String login, String password) {
		List<Agent> liste=agentDao.isExist(login, password);
		return liste;
	}

}
