package fr.adaming.managedBeans;

import java.util.List;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUserService;


@ManagedBean(name="agentMB")
@SessionScoped
public class AgentManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attributs --------------------------------------------------------------------------------------------
	private String mail;
	private String password;
	private Agent agent;
	
	private List<User> listeUser;
	
	@EJB
	IAgentService agentService;
	
	@EJB
	IUserService userService;
	
	HttpSession session;
	
	// Constructeur vide ---------------------------------------------------------------------------
	/**
	 * 
	 */
	public AgentManagedBean() {
	}

	// Getters & Setters -------------------------------------------------------------------------------------------
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
	
	// Méthodes métiers -----------------------------------------------------------------------------------
	public String isExist(){
		
		List<Agent> listeAgents=agentService.isExistService(mail, password);
		
		if (listeAgents.size()==1){
			agent=listeAgents.get(0);
			
			session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("agent", agent);
			listeUser = userService.getUserByAgentService(agent);
			return "sucess";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe ne sont pas dans la base de données."));
			return "fail";
		}
	}
	
	
	public String deconnexion(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "index.xhtml";
	}

}
