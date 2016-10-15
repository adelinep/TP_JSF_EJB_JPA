package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class User implements Serializable{

	// Attributs ---------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_u")
	private long id_user;

	private String nom;
	private String prenom;
	
	@Temporal(TemporalType.DATE)		
	private Date dN;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="agent_id", referencedColumnName="id_a")
	private Agent agent;
	
	// Constructeurs -----------------------------------------------------------------------------------------
	/** 
	 * Vide
	 */
	public User() {
		super();
	}
	/** 
	 * Sans Id
	 * @param nom
	 * @param birthDate
	 */
	public User(String nom, Date dN) {
		super();
		this.nom = nom;
		this.dN = dN;
	}
	/** 
	 * Avec Id
	 * @param id_user
	 * @param nom
	 * @param birthDate
	 */
	public User(long id_user, String nom, Date dN) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.dN = dN;
	}

	// Getters & Setters ------------------------------------------------------------------------------------
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getdN() {
		return dN;
	}
	public void setdN(Date dN) {
		this.dN = dN;
	}
	// ToString ---------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", dN=" + dN + "]";
	}

	
}
