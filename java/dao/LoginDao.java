package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginDao {

	//DB接続情報
	DaoSetting dao = new DaoSetting();

	private int checkId;
	private String checkPass;
	
	
	//SELECT 全検索
	public boolean findAll(String id, String pass){
		
		
		boolean login = false;
		//データベースへ接続
		try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){
			
			
			//SQL文
			String sqlQuery = "SELECT id, password FROM users where id= ? and password = ?";
			//SELECT id, password  FROM users ORDER BY ID DESC
			
			//SQLセット
			PreparedStatement p1 = co1.prepareStatement(sqlQuery);
			//p1.setString(1, id); //String型 でもよい
			p1.setInt(1, Integer.parseInt(id));
			p1.setString(2, pass);
			
			//実行
			ResultSet rss = p1.executeQuery();
			
		
			//int count = 0;
			
			//リスト追加
			while(rss.next()) {
				
				checkId = rss.getInt("id");
				checkPass = rss.getString("password");


				if (checkId == Integer.parseInt(id)&& checkPass.equals(pass)) {
					login = true;
					System.out.println(login);
				}else {
					login = false;
					System.out.println(login);
				}
			}
			co1.close();
		}catch(Exception e) {
			login = false;
		}
		return login;
	}
}
