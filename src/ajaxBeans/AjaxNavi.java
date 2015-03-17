package ajaxBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

@ManagedBean(name = "ajaxNavi")
@SessionScoped
public class AjaxNavi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String page;

	@PostConstruct
	public void init() {
		setPage("loginForm"); // Default include.
	}

	public String getPage() {
		System.out.println(page);
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		System.out.println(page);
	}

}