package entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress implements java.io.Serializable {

	private Integer idAdress;
	private String town;
	private String street;
	private String postalCode;
	private Set<Customers> customerses = new HashSet<Customers>(0);

	public Adress() {
	}

	public Adress(String town, String street, String postalCode,
			Set<Customers> customerses) {
		this.town = town;
		this.street = street;
		this.postalCode = postalCode;
		this.customerses = customerses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_adress", unique = true, nullable = false)
	public Integer getIdAdress() {
		return this.idAdress;
	}

	public void setIdAdress(Integer idAdress) {
		this.idAdress = idAdress;
	}

	@Column(name = "town", length = 45)
	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Column(name = "street", length = 45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "postal_code", length = 45)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adress")
	public Set<Customers> getCustomerses() {
		return this.customerses;
	}

	public void setCustomerses(Set<Customers> customerses) {
		this.customerses = customerses;
	}

}
