package fr.afpa.formation.mecanique.persistence.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value="For")
public class Formateur extends Utilisateur {

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param mail
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param identifiant
	 * @param motDePasse
	 * @param dateInscription
	 * @param dateRadiation
	 */
	public Formateur(Long id, String mail, String nom, String prenom, String telephone, String identifiant,
			String motDePasse, Date dateInscription, Date dateRadiation) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mail
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param identifiant
	 * @param motDePasse
	 * @param dateInscription
	 * @param dateRadiation
	 */
	public Formateur(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		// TODO Auto-generated constructor stub
	}




}
