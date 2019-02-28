package fr.afpa.formation.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Category")
public class Category {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Category")
	private Long id;

	@Column(name="name", nullable = false, length = 50)
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.REFRESH)
	private Set<Post> listPost = new HashSet<Post>();

	public Category() {}

	public Category(Long id, String name, Set<Post> listPost) {
		super();
		this.id = id;
		this.name = name;
		this.listPost = listPost;
	}
	
	public Category(String name, Set<Post> listPost) {
		super();
		this.name = name;
		this.listPost = listPost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Post> getListPost() {
		return listPost;
	}

	public void setListPost(Set<Post> listPost) {
		this.listPost = listPost;
	}
	
}
