package entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ord_item")
public class OrdItem implements java.io.Serializable {

	private OrdItemId id;
	private Books books;
	private Ord ord;
	private Double price;
	private String comment;

	public OrdItem() {
	}

	public OrdItem(OrdItemId id, Books books, Ord ord) {
		this.id = id;
		this.books = books;
		this.ord = ord;
	}

	public OrdItem(OrdItemId id, Books books, Ord ord, Double price,
			String comment) {
		this.id = id;
		this.books = books;
		this.ord = ord;
		this.price = price;
		this.comment = comment;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "bookId", column = @Column(name = "book_id", nullable = false)),
			@AttributeOverride(name = "ordId", column = @Column(name = "ord_id", nullable = false)) })
	public OrdItemId getId() {
		return this.id;
	}

	public void setId(OrdItemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ord_id", nullable = false, insertable = false, updatable = false)
	public Ord getOrd() {
		return this.ord;
	}

	public void setOrd(Ord ord) {
		this.ord = ord;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "comment", length = 45)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
