package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;

public class UserResgistDao {

	//DB接続情報
	DaoSetting dao = new DaoSetting();
	
	private int checkId;
	
	public boolean findAll(UserModel uM) {
		
		boolean registCheck = false;
		
		try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){
			
			
			//SQL文
			String sqlQuery = "SELECT id FROM users where id= ?";
			//SELECT id, password  FROM users ORDER BY ID DESC
			
			//SQLセット
			PreparedStatement p1 = co1.prepareStatement(sqlQuery);
			//p1.setString(1, id); //String型 でもよい
			p1.setInt(1, uM.getId());
			
			//実行
			ResultSet rss = p1.executeQuery();
		

			//リスト追加
			while(rss.next()) {
				
				//該当すると値が入る
				checkId = rss.getInt("id");

			}
			
			if (checkId != uM.getId()) {
				//該当なし
				registCheck = true;
			}else {
				//該当あり
				registCheck = false;
			}
			
			co1.close();

		}catch(Exception e) {
			registCheck = false;
		}
		
		return registCheck;
	}
	
	
	
	
	public boolean regist(UserModel uM) {
		
		final int delete_key = 0;
		boolean regist = false;

		//データベースへ接続
		try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){

			PreparedStatement p1 = co1.prepareStatement("Insert Into users(id, name, password, edit, department_key, delete_key)VALUES(?,?,?,?,?,?)");

			p1.setInt(1, uM.getId());
			p1.setString(2, uM.getName());
			p1.setString(3, uM.getPass());
			p1.setInt(4, uM.getEdit());
			p1.setInt(5, uM.getDepartment_key());
			p1.setInt(6, delete_key);
			
			//実行
			p1.executeUpdate();
			regist= true;
			
			co1.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			regist = false;
		}
		
		return regist;
		
	}
	
}
