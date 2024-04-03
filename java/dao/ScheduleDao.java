package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ScheduleModel;


//自分の予定
public class ScheduleDao {

	//登録用に変換
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
	
	//DB接続情報
	DaoSetting dao = new DaoSetting();

	
	//全件検索
	//ユーザーID
	//スケジュールテーブル
	public List<ScheduleModel> findAll(ScheduleModel sM){

	List<ScheduleModel> sList = new ArrayList<ScheduleModel>();
	
	try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){
		
		//SQL文
		String sqlQuery = "SELECT *  FROM schedule where user_id= ?";
		//SELECT *  FROM schedule where id= ?
		PreparedStatement ps = co1.prepareStatement(sqlQuery);
		ps.setInt(1, sM.getUser_id());
		
		//実行
		ResultSet rss = ps.executeQuery();
		

		while(rss.next()) {
			
			ScheduleModel sc = new ScheduleModel();

			sc.setId(rss.getInt("id"));
			sc.setWork_name(rss.getString("work_name"));
			sc.setWork_memo(rss.getString("work_memo"));
			sc.setStart(fmt.format(rss.getDate("start")));
			sc.setEnd(fmt.format(rss.getDate("end")));
			sc.setUser_id(rss.getInt("user_id"));
			sc.setDelete_key(rss.getInt("delete_key"));

			sList.add(sc);
		}

	}catch(SQLException e) {
		e.printStackTrace();
	}
	return sList;
	}

	

	
	
	//特定検索
	//スケジュールID
	//スケジュールテーブル
	public ScheduleModel change(int schId){
		
		ScheduleModel sc = new ScheduleModel();
	
		
	try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){
		
		//SQL文
		String sqlQuery = "SELECT *  FROM schedule where id= ?";
		//SELECT *  FROM schedule where id= ?
		PreparedStatement ps = co1.prepareStatement(sqlQuery);
		ps.setInt(1, schId);
		
		//実行
		ResultSet rss = ps.executeQuery();

			while(rss.next()) {
				
				sc.setId(rss.getInt("id"));
				sc.setWork_name(rss.getString("work_name"));
				sc.setWork_memo(rss.getString("work_memo"));
				sc.setStart(fmt.format(rss.getDate("start")));
				sc.setEnd(fmt.format(rss.getDate("end")));
				sc.setUser_id(rss.getInt("user_id"));
				sc.setDelete_key(rss.getInt("delete_key"));
				
			}

	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return sc;
	
	}
	
	
	
	
	//特定更新
	//スケジュールID
	//スケジュールテーブル
	public boolean update(ScheduleModel sM) throws ParseException{
		
		boolean update = false;
	
	try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){

		//ロジック
		Date start_data = fmt.parse(sM.getStart());
		Date end_data = fmt.parse(sM.getStart());
		sM.setStart(fmtDate.format(start_data));
		sM.setEnd(fmtDate.format(end_data));
		

		//SQL文
		String sqlQuery = "Update schedule SET work_name = ?, work_memo = ?, start = ?, end = ?   Where id = ?";
		//SELECT *  FROM schedule where id= ?
		PreparedStatement ps = co1.prepareStatement(sqlQuery);
		ps.setString(1, sM.getWork_name());
		ps.setString(2, sM.getWork_memo());
		ps.setString(3, sM.getStart());
		ps.setString(4, sM.getEnd());
		ps.setInt(5, sM.getId());
		

		//実行
		ps.executeUpdate();
		
		update = true;
		co1.close();
	}catch(SQLException e) {
		//SQLException だと Datetimeで例外
		//throws ParseException 付与
		e.printStackTrace();
		update = false;
	}
	return update;
	
	}
	
	
	
	
	
	//特定削除(UPDATE-)
	//スケジュールID
	//スケジュールテーブル
public List<ScheduleModel> delete(ScheduleModel sM) {
		
	List<ScheduleModel> sML = new ArrayList<ScheduleModel>();
	
	
	try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(),dao.getDBId(),dao.getDBPass())){


		//SQL文
		String sqlQuery = "Update schedule SET  delete_key = ?   Where id = ?";
		//SELECT *  FROM schedule where id= ?
		PreparedStatement ps = co1.prepareStatement(sqlQuery);
		ps.setInt(1, 1);
		ps.setInt(2, sM.getId());
		

		//実行
		ps.executeUpdate();
		
		
		//SQL文
		sqlQuery = "SELECT * FROM schedule Where delete_key = ? and user_id = ?";
		

		
		ps = co1.prepareStatement(sqlQuery);
		ps.setInt(1, 0);
		ps.setInt(2, sM.getUser_id());
		
		
		//実行
		ResultSet rss = ps.executeQuery();
		
		while(rss.next()) {
			
			ScheduleModel sc = new ScheduleModel();
			
			sc.setId(rss.getInt("id"));
			sc.setWork_name(rss.getString("work_name"));
			sc.setWork_memo(rss.getString("work_memo"));
			sc.setStart(fmt.format(rss.getDate("start")));
			sc.setEnd(fmt.format(rss.getDate("end")));
			sc.setUser_id(rss.getInt("user_id"));
			sc.setDelete_key(rss.getInt("delete_key"));
			
			sML.add(sc);
		}
		

		co1.close();
	}catch(SQLException e) {
		//SQLException だと Datetimeで例外
		//throws ParseException 付与
		e.printStackTrace();
	}
	return sML;
	
	}


}
