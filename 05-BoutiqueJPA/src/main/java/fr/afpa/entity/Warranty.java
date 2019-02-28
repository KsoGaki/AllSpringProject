package fr.afpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Warranty")
public class Warranty {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="id_Warranty")
	long id;

	@Column(name="summary", columnDefinition="VARCHAR(255)", nullable=false)
	String summary;

	@Column(name="fullTexte", columnDefinition="VARCHAR(255)", nullable=false)
	String fullText;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Item")
	Item item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public Warranty(String summary, String fullText, Item item) {
		super();
		this.item = item;
		this.summary = summary;
		this.fullText = fullText;
	}




}
