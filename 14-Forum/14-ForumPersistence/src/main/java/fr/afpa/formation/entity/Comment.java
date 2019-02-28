package fr.afpa.formation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Comment")
	private Long id;
 
	@Column(name="userName", nullable = false, length = 50)
	private String userName;

	@Column(name="message", nullable = false, length = 1000)
	private String message;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date", nullable = false, length = 50)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Post", nullable=false)
	private Post post;

	@PrePersist
	protected void onCreate() {
		date = new Date();
	}

	public Comment() {}

	public Comment(Long id, String userName, String message, Post post) {
		super();
		this.id = id;
		this.userName = userName;
		this.message = message;
		this.post = post;
	}

	public Comment(String userName, String message, Post post) {
		super();
		this.userName = userName;
		this.message = message;
		this.post = post;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
