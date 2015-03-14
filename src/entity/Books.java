package entity;


import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "books")
public class Books implements java.io.Serializable {

	private Integer idBooks;
	private String isbn;
	private String title;
	private Date publicationDate;
	private String comment;
	private Set<OrdItem> ordItems = new HashSet<OrdItem>(0);
	private Set<Authors> authorses = new HashSet<Authors>(0);
	private Set<Categories> categorieses = new HashSet<Categories>(0);

	public Books() {
	}

	public Books(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public Books(String isbn, String title, Date publicationDate,
			String comment, Set<OrdItem> ordItems, Set<Authors> authorses,
			Set<Categories> categorieses) {
		this.isbn = isbn;
		this.title = title;
		this.publicationDate = publicationDate;
		this.comment = comment;
		this.ordItems = ordItems;
		this.authorses = authorses;
		this.categorieses = categorieses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_books", unique = true, nullable = false)
	public Integer getIdBooks() {
		return this.idBooks;
	}

	public void setIdBooks(Integer idBooks) {
		this.idBooks = idBooks;
	}

	@Column(name = "isbn", nullable = false, length = 45)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "title", nullable = false, length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "publication_date", length = 10)
	public Date getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Column(name = "comment", length = 45)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "books")
	public Set<OrdItem> getOrdItems() {
		return this.ordItems;
	}

	public void setOrdItems(Set<OrdItem> ordItems) {
		this.ordItems = ordItems;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "books_has_authors", catalog = "mareko", joinColumns = { @JoinColumn(name = "books_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authors_id", nullable = false, updatable = false) })
	public Set<Authors> getAuthorses() {
		return this.authorses;
	}

	public void setAuthorses(Set<Authors> authorses) {
		this.authorses = authorses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "books_has_categories", catalog = "mareko", joinColumns = { @JoinColumn(name = "book_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "categories_id", nullable = false, updatable = false) })
	public Set<Categories> getCategorieses() {
		return this.categorieses;
	}

	public void setCategorieses(Set<Categories> categorieses) {
		this.categorieses = categorieses;
	}

}
