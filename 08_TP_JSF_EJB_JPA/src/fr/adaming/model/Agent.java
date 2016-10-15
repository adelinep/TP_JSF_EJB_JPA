package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agents")
public class Agent implements Serializable{

	// Attributs ---------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_a")
	private long id_agent;
	
	private String login;
	@Column(name="mdp")
	private String password;
	
	@OneToMany(mappedBy="agent", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	private List<User> listUser;
	
	// Constructeurs -----------------------------------------------------------------------------------------
	/** 
	 * Vide
	 */
	public Agent() {
		super();
	}
	/** 
	 * Sans Id
	 * @param login
	 * @param password
	 */
	public Agent(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	/** 
	 * Avec Id
	 * @param id_agent
	 * @param login
	 * @param password
	 */
	public Agent(long id_agent, String login, String password) {
		super();
		this.id_agent = id_agent;
		this.login = login;
		this.password = password;
	}
	
	// Getters & Setters -------------------------------------------------------------------------------------
	public long getId_agent() {
		return id_agent;
	}
	public void setId_agent(long id_agent) {
		this.id_agent = id_agent;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	
	// ToString ----------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Agent [id_agent=" + id_agent + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	
}
