package model;

import dao.UserResgistDao;

public class UserResgistLogic {
	
	
	
	public boolean find(UserModel user) {
		
		boolean find = false;
		UserResgistDao uLD = new UserResgistDao();
		
		find = uLD.findAll(user);

		return find;		
	}
	
	
	public boolean execute(UserModel user) {
		
		boolean regist = false;
		UserResgistDao uLD = new UserResgistDao();
		
		regist = uLD.regist(user);

		return regist;
		
	}
}
