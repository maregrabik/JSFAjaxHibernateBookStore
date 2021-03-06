package entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_data")
public class LoginData implements java.io.Serializable {

	private Integer idLoginData;
	private String login;
	private String password;
	private Customers customerses = new Customers();

	public LoginData() {
	}

	public LoginData(String login, String password, Customers customerses) {
		this.login = login;
		this.password = password;
		this.customerses = customerses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_login_data", unique = true, nullable = false)
	public Integer getIdLoginData() {
		return this.idLoginData;
	}

	public void setIdLoginData(Integer idLoginData) {
		this.idLoginData = idLoginData;
	}

	@Column(name = "login", length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", length = 255)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "loginData")
	public Customers getCustomerses() {
		return this.customerses;
	}

	public void setCustomerses(Customers customerses) {
		this.customerses = customerses;
	}

}
