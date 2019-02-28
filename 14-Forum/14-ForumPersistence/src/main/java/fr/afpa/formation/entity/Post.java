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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Post")
public class Post {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Post")

	private Long id;

	@Column(name="postName", nullable = false, length = 50)
	private String postName;

	@Column(name="authorName", nullable = false, length = 50)
	private String authorName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Category", nullable=false)
	private Category category;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post", cascade = CascadeType.REFRESH)
	@OrderBy
	private Set<Comment> listComment = new HashSet<Comment>();

	public Post() {}

	public Post(Long id, String postName, String authorName, Category category) {
		super();
		this.id = id;
		this.postName = postName;
		this.authorName = authorName;
		this.category = category;
	}

	public Post(String postName, String authorName, Category category) {
		super();
		this.postName = postName;
		this.authorName = authorName;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(Set<Comment> listComment) {
		this.listComment = listComment;
	}

}
