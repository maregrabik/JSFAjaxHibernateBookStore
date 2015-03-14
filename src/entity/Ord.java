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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ord")
public class Ord implements java.io.Serializable {

	private Integer idOrd;
	private Customers customers;
	private Date orderDate;
	private Double orderValue;
	private Set<OrdItem> ordItems = new HashSet<OrdItem>(0);

	public Ord() {
	}

	public Ord(Customers customers, Date orderDate) {
		this.customers = customers;
		this.orderDate = orderDate;
	}

	public Ord(Customers customers, Date orderDate, Double orderValue,
			Set<OrdItem> ordItems) {
		this.customers = customers;
		this.orderDate = orderDate;
		this.orderValue = orderValue;
		this.ordItems = ordItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ord", unique = true, nullable = false)
	public Integer getIdOrd() {
		return this.idOrd;
	}

	public void setIdOrd(Integer idOrd) {
		this.idOrd = idOrd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date", nullable = false, length = 10)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "order_value", precision = 22, scale = 0)
	public Double getOrderValue() {
		return this.orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ord")
	public Set<OrdItem> getOrdItems() {
		return this.ordItems;
	}

	public void setOrdItems(Set<OrdItem> ordItems) {
		this.ordItems = ordItems;
	}

}
