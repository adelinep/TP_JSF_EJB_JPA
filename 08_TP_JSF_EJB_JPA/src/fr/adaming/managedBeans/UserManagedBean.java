package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IUserService;

@ManagedBean(name="userMB")
@SessionScoped
public class UserManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs ----------------------------------------------------------------------------------------------------------------
	private User user;
	private Agent agent;

	HttpSession session;
	List<User> userList;

	@EJB
	IUserService userService;

	@PostConstruct
	private void init() {
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		agent=(Agent) session.getAttribute("agent");
	}

	// Constructeur vide -----------------------------------------------------------------------------------------------------------
	public UserManagedBean() {
		this.user = new User();
	}

	// Getters & Setters ------------------------------------------------------------------------------------------------------------
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	// Méthodes ----------------------------------------------------------------------------------------------------------------------
	public String addUser(){
		user.setAgent(agent);
		userService.addUserService(user);

		userList = userService.getUserByAgentService(agent);
		session.setAttribute("listUser", userList);
		return "accueil.xhtml";
	}

	public String deleteUser(){
		userService.deleteUserService(user);

		userList = userService.getUserByAgentService(agent);
		session.setAttribute("listUser", userList);
		return "accueil.xhtml";
	}

	public String updateUser(){
		userService.updateUserService(user);

		userList = userService.getUserByAgentService(agent);
		session.setAttribute("listUser", userList);
		return "accueil.xhtml";
	}


	public String getUserById(){
		userList = userService.getUserByAgentService(agent);
		session.setAttribute("listUser", userList);
		this.user = userService.getUserByIdService(user.getId_user());
		return "#";

	}

}
