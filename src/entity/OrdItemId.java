package entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrdItemId implements java.io.Serializable {

	private int bookId;
	private int ordId;

	public OrdItemId() {
	}

	public OrdItemId(int bookId, int ordId) {
		this.bookId = bookId;
		this.ordId = ordId;
	}

	@Column(name = "book_id", nullable = false)
	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Column(name = "ord_id", nullable = false)
	public int getOrdId() {
		return this.ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdItemId))
			return false;
		OrdItemId castOther = (OrdItemId) other;

		return (this.getBookId() == castOther.getBookId())
				&& (this.getOrdId() == castOther.getOrdId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getBookId();
		result = 37 * result + this.getOrdId();
		return result;
	}

}
