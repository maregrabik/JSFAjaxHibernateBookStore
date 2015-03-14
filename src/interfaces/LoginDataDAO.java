package interfaces;

import entity.LoginData;

public interface LoginDataDAO {
	boolean isValid(LoginData loginData);
}
