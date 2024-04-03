package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistDao {

	public boolean workRegist(
			String work_name,
			String work_memo,
			String start,
			String end,
			int user_id
			) {
		

		
		//DB接続情報
		DaoSetting dao = new DaoSetting();
		final int delete_key = 0;
		boolean regist = false;

		//データベースへ接続
		try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){

			PreparedStatement p1 = co1.prepareStatement("Insert Into schedule(work_name, work_memo, start, end, delete_key, user_id)VALUES(?,?,?,?,?,?)");
			
			p1.setString(1, work_name);
			p1.setString(2, work_memo);
			p1.setString(3, start);
			p1.setString(4, end);
			p1.setInt(5, delete_key);
			p1.setInt(6, user_id);
			
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
