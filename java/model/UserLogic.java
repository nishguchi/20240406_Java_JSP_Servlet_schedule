package model;

import dao.UserDao;

	public class UserLogic {
		
		public boolean execute(LoginModel lM, UserModel uM) {
			
			boolean userData = false;
			UserDao d1 = new UserDao();
			
			userData = d1.findAll(lM,uM);
			
			return userData;	
		}
}
