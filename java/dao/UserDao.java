package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LoginModel;
import model.UserModel;

public class UserDao {

	//DB接続情報
	DaoSetting dao = new DaoSetting();
	
	
	//SELECT 全検索  String id, String pass
	public boolean findAll(LoginModel lM , UserModel uM){
		
		boolean userData = false;
		
		//データベースへ接続
		try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){
			
			
			//SQL文
			String sqlQuery = "SELECT * FROM users where id= ? and password = ?";
			//SELECT id, password  FROM users ORDER BY ID DESC
			
			//SQLセット
			PreparedStatement p1 = co1.prepareStatement(sqlQuery);
			
			p1.setString(1, lM.getId());
			p1.setString(2, lM.getPass());
			
			//実行
			ResultSet rss = p1.executeQuery();

			//リスト追加
			while(rss.next()) {

				uM.setId(rss.getInt("id"));
				uM.setPass(rss.getString("password"));
				uM.setName(rss.getString("name"));
				uM.setEdit(rss.getInt("edit"));
//				uM.setWork_num(rss.getString("work_num"));
				uM.setDelete_key(rss.getInt("delete_key"));
				

				if (!(rss.getString("id").equals(""))) {
					userData = true;
				}else {
					userData = false;
				}

			}
			co1.close();
		}catch(Exception e) {
			userData = false;
		}
		return userData;
	}

}
