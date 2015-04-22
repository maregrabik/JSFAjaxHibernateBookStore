package DAO;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;
import interfaces.LoginDataDAO;
import entity.LoginData;

public class LoginDataDAOimpl extends BaseDAOimpl<LoginData> implements LoginDataDAO {

	private LoginData loginData;
	public LoginDataDAOimpl(Class<LoginData> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public LoginDataDAOimpl() {
		this(LoginData.class);
		setLoginData(new LoginData());
	}


	@Override
	public boolean isValid(LoginData loginData) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query querry = session.createQuery("from LoginData where login =:login and password =:password");
		querry.setParameter("login", loginData.getLogin());
		querry.setParameter("password", loginData.getPassword());
		List<LoginData> x = querry.list();
		for (LoginData loginData2 : x) {
		 System.out.println(loginData2.getIdLoginData());
		}

		if (x.size() > 0) {
			this.setLoginData(x.get(0));
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return the loginData
	 */
	public LoginData getLoginData() {
		return loginData;
	}

	/**
	 * @param loginData the loginData to set
	 */
	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

}
