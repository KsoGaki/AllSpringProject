package fr.afpa.formation.mecanique.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="STA")
public class Stagiaire extends Utilisateur {

	@Column(unique=true)
	private String numeroCarte;

	public Stagiaire() {
		super();
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
	public Stagiaire(Long id, String mail, String nom, String prenom, String telephone, String identifiant,
			String motDePasse, Date dateInscription, Date dateRadiation, String numeroCarte) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		this.numeroCarte = numeroCarte;
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
	public Stagiaire(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation, String numeroCarte) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		this.numeroCarte = numeroCarte;
	}





}
