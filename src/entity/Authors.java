package entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Authors implements java.io.Serializable {

	private Integer idAuthors;
	private String authorFirstName;
	private String authorInitials;
	private String fullName;
	private Set<Books> bookses = new HashSet<Books>(0);

	public Authors() {
	}

	public Authors(String authorFirstName, String authorInitials,
			String fullName, Set<Books> bookses) {
		this.authorFirstName = authorFirstName;
		this.authorInitials = authorInitials;
		this.fullName = fullName;
		this.bookses = bookses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_authors", unique = true, nullable = false)
	public Integer getIdAuthors() {
		return this.idAuthors;
	}

	public void setIdAuthors(Integer idAuthors) {
		this.idAuthors = idAuthors;
	}

	@Column(name = "author_first_name", length = 45)
	public String getAuthorFirstName() {
		return this.authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	@Column(name = "author_initials", length = 45)
	public String getAuthorInitials() {
		return this.authorInitials;
	}

	public void setAuthorInitials(String authorInitials) {
		this.authorInitials = authorInitials;
	}

	@Column(name = "full_name", length = 45)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "books_has_authors", catalog = "mareko", joinColumns = { @JoinColumn(name = "authors_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "books_id", nullable = false, updatable = false) })
	public Set<Books> getBookses() {
		return this.bookses;
	}

	public void setBookses(Set<Books> bookses) {
		this.bookses = bookses;
	}

}
