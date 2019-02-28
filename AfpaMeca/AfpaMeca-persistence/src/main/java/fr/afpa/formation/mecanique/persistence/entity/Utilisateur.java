package fr.afpa.formation.mecanique.persistence.entity;

import java.util.Date;

import javax.persistence.Column;

public abstract class Utilisateur extends Personne {
	
	@Column(unique = true, length = 50)
	private String identifiant;
	@Column(length = 25)
	private String motDePasse;
	@Column(length = 25)
	private Date dateInscription;
	private Date dateRadiation;
	
	
	

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Utilisateur() {}
	
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Utilisateur(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone);
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.dateRadiation = dateRadiation;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Utilisateur(Long id,String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(id,mail, nom, prenom, telephone);
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.dateRadiation = dateRadiation;
	}

	@Override
	public String toString() {
		return "Utilisateur identifiant = " + identifiant + " motDePasse = " + motDePasse + " dateInscription = "
				+ dateInscription + " dateRadiation = " + dateRadiation;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateRadiation() {
		return dateRadiation;
	}

	public void setDateRadiation(Date dateRadiation) {
		this.dateRadiation = dateRadiation;
	}
	
	
	
	
}
