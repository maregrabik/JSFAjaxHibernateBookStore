/**
 * 
 */
package ajaxBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import beans.LoginDataBean;

/**
 * @author Marek
 *
 */

@ManagedBean(name = "userPanelAjaxActions")
@RequestScoped
public class UserPanelAjaxActions {

	@ManagedProperty(value = "#{loginDataBean}")
	private LoginDataBean loginDataBean;

	public void updateUserData() {

		System.out.println(getLoginDataBean().getLoginData().getCustomerses());
		

	}

	/**
	 * @return the loginDataBean
	 */
	public LoginDataBean getLoginDataBean() {
		return loginDataBean;
	}

	/**
	 * @param loginDataBean the loginDataBean to set
	 */
	public void setLoginDataBean(LoginDataBean loginDataBean) {
		this.loginDataBean = loginDataBean;
	}

}
