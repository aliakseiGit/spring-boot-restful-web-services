package rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
//@JsonFilter("IgnoreUser_birthDateFilter")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	@JsonProperty("user_id")
	private Integer id;

	@Column(name = "user_name")
	@JsonProperty("user_name")
	@JacksonXmlProperty(localName = "xml_user_name")
	@Size(min = 2, message = "Name should have at least 2 character")
	private String name;

	@Column(name = "user_birthdate")
	@JsonProperty("user_birthdate")
	@JacksonXmlProperty(localName = "xml_user_birthdate")
	@Past(message = "Birthdate should be in the past")
	private LocalDate birthDate;

	@Transient
	@JsonIgnore
	private String uselessField = "Useless field";

	@Transient
	@JsonIgnore
	private String anotherUselessField = "Another useless field";

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	public User() {
	}

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public User(Integer id, String name, LocalDate birthDate, String uselessField, String anotherUselessField) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.uselessField = uselessField;
		this.anotherUselessField = anotherUselessField;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getUselessField() {
		return uselessField;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}


