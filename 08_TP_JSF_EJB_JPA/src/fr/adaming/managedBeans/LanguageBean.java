package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="interBean")
@SessionScoped
public class LanguageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attributs ------------------------------------------------------------------------------------------------------------------------
	private static Map<String, Object> localites;
	
	private Locale local=FacesContext.getCurrentInstance().getViewRoot().getLocale();
	
	private String localCode = local.toString();
	
	private int menu;

	// Constructeurs ----------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	public LanguageBean() {
		super();
	}
	
	/**
	 * Constructeur Statique
	 */
	static{
	localites=new HashMap<String, Object>();
	localites.put("Francais", Locale.FRANCE);
	localites.put("Anglais", Locale.US);
	}

	// Getters & Setters ----------------------------------------------------------------------------------------------------------------
	/**
	 * @return the localites
	 */
	public Map<String, Object> getLocalites() {
		return localites;
	}

	/**
	 * @param localites the localites to set
	 */
	public static void setLocalites(Map<String, Object> localitess) {
		localites = localitess;
		
	}

	/**
	 * @return the local
	 */
	public Locale getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(Locale local) {
		this.local = local;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public int getMenu() {
		return menu;
	}

	public void setMenuSelect(int menu) {
		this.menu = menu;
	}
	
	// Méthodes --------------------------------------------------------------------------------------------------------------------------
	public void changerLocalite(ValueChangeEvent event){
		String nouvelleLocale = (String) event.getNewValue();
		
		for(Map.Entry<String, Object> entry:localites.entrySet()){
			if(nouvelleLocale.equals(entry.getValue().toString())){
				FacesContext context= FacesContext.getCurrentInstance();
				
				UIViewRoot page=context.getViewRoot();
				
				page.setLocale((Locale) entry.getValue());
				
				this.setLocalCode(entry.getValue().toString());
				
				this.local=FacesContext.getCurrentInstance().getViewRoot().getLocale();
			}
		}
	}





}

