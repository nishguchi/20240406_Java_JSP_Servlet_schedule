package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.RegistDao;

public class RegistLogic {
	
	public boolean execute(
			String work_name,
			String work_memo,
			String start,
			String end,
			int user_id
			) {
		
		boolean regist = false;
		RegistDao r1 = new RegistDao();


		//登録用に変換
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		
		try {

			
			Date start_data = fmt.parse(start);
			start = fmt2.format(start_data);
			
			Date end_data = fmt.parse(end);
			end = fmt2.format(end_data);
			


		} catch (ParseException e) {
			e.printStackTrace();
			regist = false;
		}
		
		regist = r1.workRegist(
			 work_name,
			 work_memo,
			 start,
			 end,
			 user_id
				);
		return regist;
	}
}
