package model;

import dao.LoginDao;

public class LoginLogic {
	
	public boolean execute(String id, String pass) {
		boolean login = false;
		LoginDao d1 = new LoginDao();
		login = d1.findAll(id, pass);
		return login;	
	}
}
