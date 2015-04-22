package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import ajaxBeans.AjaxNavi;
import DAO.LoginDataDAOimpl;
import entity.Customers;
import entity.LoginData;

@ManagedBean(name = "loginDataBean")
@SessionScoped
public class LoginDataBean {

	private LoginData loginData;
	private Customers customer;
	private String username;
	private String password;
	private boolean isLoged = false;

	@ManagedProperty(value = "#{ajaxNavi}")
	private AjaxNavi ajaxNavi;

	public LoginDataBean() {
		this.username = "George";
		this.password = "george";
		this.isLoged = false;
	}

	/**
	 * @return the loginData
	 */
	public LoginData getLoginData() {
		return loginData;
	}

	/**
	 * @param loginData
	 *            the loginData to set
	 */
	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	/**
	 * @return the isLoged
	 */
	public boolean isLoged() {
		return isLoged;
	}

	/**
	 * @param isLoged
	 *            the isLoged to set
	 */
	public void setLoged(boolean isLoged) {
		this.isLoged = isLoged;
	}

	/**
	 * @return the ajaxNavi
	 */
	public AjaxNavi getAjaxNavi() {
		return ajaxNavi;
	}

	/**
	 * @param ajaxNavi
	 *            the ajaxNavi to set
	 */
	public void setAjaxNavi(AjaxNavi ajaxNavi) {
		this.ajaxNavi = ajaxNavi;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void loginAttempt() {

		LoginDataDAOimpl loginDataDAO = new LoginDataDAOimpl();
		FacesContext context = FacesContext.getCurrentInstance();

		LoginData loginData = new LoginData();
		loginData.setLogin(username);
		String pw = DigestUtils.sha256Hex(password);
		loginData.setPassword(pw);
		setLoged(loginDataDAO.isValid(loginData));

		if (isLoged) {
			getAjaxNavi().setPage("start");
			context.addMessage(null, new FacesMessage("You have succesfully loged in, welcome: " + loginData.getLogin()));
			this.customer = loginDataDAO.getLoginData().getCustomerses();
			System.out.println("dawaj start");
		} else {
			getAjaxNavi().setPage("loginForm");
			context.addMessage(null, new FacesMessage("Error occured while looging in, pleas try again"));
			System.out.println("dawaj login");
		}
	}

	/**
	 * @return the customer
	 */
	public Customers getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

}
