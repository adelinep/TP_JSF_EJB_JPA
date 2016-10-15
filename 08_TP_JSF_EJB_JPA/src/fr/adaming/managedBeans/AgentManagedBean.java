package fr.adaming.managedBeans;

import java.util.List;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IAgentService;


@ManagedBean(name="agentMB")
@SessionScoped
public class AgentManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String password;
	private Agent agent;
	
	private List<User> listeUser;
	
	@EJB
	IAgentService agentService;
	/**
	 * 
	 */
	public AgentManagedBean() {
		super();
	}
	/**
	 * @param mail
	 * @param password
	 */
	public AgentManagedBean(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public List<User> getListeUser() {
		return listeUser;
	}
	public void setListeUser(List<User> listeUser) {
		this.listeUser = listeUser;
	}
	
	// Méthods métiers
	public String isExist(){
		
		List<Agent> listeAgents=agentService.isExistService(mail, password);
		
		if (listeAgents.size()==1){
			agent=listeAgents.get(0);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);
			return "sucess";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe ne sont pas dans la base de données."));
			return "fail";
		}
	}

}
