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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers implements java.io.Serializable {

	private Integer idCustomers;
	private Adress adress;
	private LoginData loginData;
	private String fullName;
	private String phone;
	private String email;
	private Set<Ord> ords = new HashSet<Ord>(0);

	public Customers() {
	}

	public Customers(Adress adress, LoginData loginData, String fullName) {
		this.adress = adress;
		this.loginData = loginData;
		this.fullName = fullName;
	}

	public Customers(Adress adress, LoginData loginData, String fullName,
			String phone, String email, Set<Ord> ords) {
		this.adress = adress;
		this.loginData = loginData;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.ords = ords;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_customers", unique = true, nullable = false)
	public Integer getIdCustomers() {
		return this.idCustomers;
	}

	public void setIdCustomers(Integer idCustomers) {
		this.idCustomers = idCustomers;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Adress_id", nullable = false)
	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Login_data_id", nullable = false)
	public LoginData getLoginData() {
		return this.loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	@Column(name = "full_name", nullable = false, length = 45)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	public Set<Ord> getOrds() {
		return this.ords;
	}

	public void setOrds(Set<Ord> ords) {
		this.ords = ords;
	}

}
