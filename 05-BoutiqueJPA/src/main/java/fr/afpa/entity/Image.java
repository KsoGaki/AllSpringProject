package fr.afpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Image")
public class Image {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="id_Image")
	long id;
	
	@Column(name="altText", columnDefinition="VARCHAR(255)", nullable=false)
	String altText;
	
	@Column(name="path", columnDefinition="VARCHAR(255)", nullable=false, unique=true)
	String path;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Item")
	private Item item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Image(String altText, String path, Item item) {
		super();
		this.altText = altText;
		this.path = path;
		this.item = item;
	}
	
	public Image(int id, String altText, String path, Item item) {
		super();
		this.id = id;
		this.altText = altText;
		this.path = path;
		this.item = item;
	}
	
	public Image(String altText, String path) {
		super();
		this.altText = altText;
		this.path = path;
	}
	
	public Image() {
		 
	}
}
