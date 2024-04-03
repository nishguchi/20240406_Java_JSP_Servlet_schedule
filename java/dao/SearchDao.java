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


public class SearchDao {

	
	//DB接続情報
	DaoSetting dao = new DaoSetting();
	
	//Data変換
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
	
	
	private int id;
	private String work_name;
	private String work_memo;
	private String start;
	private String end;
	private int userId;
	
	private Date startData;
	private Date endData;
	
	private ArrayList<String> sqlBox = new ArrayList<String>();
	//private String[] sqlBox;
	private int count = 0;
	
	
	private String sql; 
	
	
	public List<ScheduleModel> search(ScheduleModel sM) throws ParseException{
		
		//boolean search = false;
		List<ScheduleModel> sML = new ArrayList<ScheduleModel>();
		
		
		try (Connection co1 = DriverManager.getConnection(dao.getJDBCSet(), dao.getDBId(), dao.getDBPass())){

			id = sM.getId();
			work_name = sM.getWork_name();
			work_memo = sM.getWork_memo();
			start = sM.getStart();
			end = sM.getEnd();
			userId = sM.getUser_id();
			
			if(!(start.isEmpty())) {
				//変換
				startData = fmt.parse(start);
				start = fmtDate.format(startData);
			}
			
			if(!(end.isEmpty())) {
				//変換
				endData = fmt.parse(end);
				end = fmtDate.format(endData);
			}


			boolean work_name_flag = false;
			boolean work_memo_flag = false;
			boolean start_flag = false;
			boolean end_flag = false;
			boolean userId_flag = false;
			boolean id_flag = false;
			
			
			int work_name_count = 0;
			int work_memo_count = 0;
			int start_count = 0;
			int end_count = 0;
			int userId_count = 0;			
			int id_count = 0;
			
			
			
//			System.out.println(id);
//			System.out.println(work_name);
//			System.out.println(work_memo);
//			System.out.println(start);
//			System.out.println(end);
//			System.out.println(userId);
			

			

			
			//初期値
			sql = "SELECT * FROM schedule";

			 if(!(work_name.isEmpty())) {
				 count += 1;
				 System.out.println(count + "count");
				if(count == 1 ) {
					sqlBox.add(" work_name LIKE ?");
				}else {
					sqlBox.add(" and work_name LIKE ?");
				}
				 work_name_flag = true;
				 work_name_count = count;
			 }
			 
			 if(!(work_memo.isEmpty())) {
				 count += 1;
				 System.out.println(count + "count");
				 System.out.println(work_memo);
				if(count == 1 ) {
					 sqlBox.add(" work_memo LIKE ?");
				}else {
					 sqlBox.add(" and work_memo LIKE ?");
				}
				 work_memo_flag = true;
				 work_memo_count = count;
			 }
			 
			 
			 if(!(start.isEmpty())) {
				 count += 1;
				if(count == 1 ) {
					 sqlBox.add(" start = ?");
				}else {
					 sqlBox.add(" and start = ?");
				}
				 start_flag = true;
				 start_count = count;
			 }
			 
			 if(!(end.isEmpty())) {
				 count += 1;
				 
				if(count == 1 ) {
					 sqlBox.add(" end = ?");
				}else {
					 sqlBox.add(" and end = ?");
				}
				 end_flag = true;
				 end_count = count;
			 }
			 
			if(userId > 0) {
				count += 1;
				if(count == 1 ) {
					 sqlBox.add(" user_id = ?");
				}else {
					 sqlBox.add(" and user_id = ?");
				}
				userId_flag = true;
				userId_count = count;
			}
			
			
			if(id > 0) {
				count += 1;
				if(count == 1 ) {
					 sqlBox.add(" id = ?");
				}else {
					 sqlBox.add(" and id = ?");
				}
				id_flag = true;
				id_count = count;
			}
			
			
			
			//宣言
			//プリペアステートメント
			//リゾルトセット
			PreparedStatement ps;
			ResultSet rss;
			
			
//			 //SQL文連結
			if(count > 0) {

				sql+= " Where";
				//配列回す
				for(String s : sqlBox) {
					sql+= s;
					System.out.println(s);
				}

			}

			 ps = co1.prepareStatement(sql);
			 System.out.println(ps);


			
			if(work_name_flag) {
				 ps.setString(work_name_count, '%' + work_name + '%');
			}
			if(work_memo_flag) {
				ps.setString(work_memo_count, '%' + work_memo + '%'); 
			}
			
			if(start_flag) {
				ps.setString(start_count, start);
			}
			if(end_flag) {
				ps.setString(end_count, end);
			}	
			
			if(userId_flag) {
				ps.setInt(userId_count, userId);
			}
			
			if(id_flag) {
				ps.setInt(id_count, id);
			}
			
			rss = ps.executeQuery();
			System.out.println(ps);
			
			

			
			
			
			while(rss.next()) {
				
				ScheduleModel sMs = new ScheduleModel();
				
				sMs.setId(rss.getInt("id"));
				sMs.setWork_name(rss.getString("work_name"));
				sMs.setWork_memo(rss.getString("work_memo"));
				sMs.setStart(fmt.format(rss.getDate("start")));
				sMs.setEnd(fmt.format(rss.getDate("end")));
				sMs.setDelete_key(rss.getInt("delete_key"));
				sMs.setUser_id(rss.getInt("user_id"));
				
				
				
//				System.out.println(rss.getInt("id"));
//				System.out.println(rss.getString("work_name"));
//				System.out.println(rss.getString("work_memo"));
//				System.out.println(rss.getDate("start"));
//				System.out.println(rss.getDate("end"));
//				System.out.println(rss.getInt("delete_key"));
//				System.out.println(rss.getInt("user_id"));
				
				
				sML.add(sMs);

			}
			
			//search = true;
			co1.close();
		}catch(SQLException e) {
			e.printStackTrace();
			//search = false;
		}
		
		return sML;
		
	}
	

	
}
