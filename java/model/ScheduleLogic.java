package model;

import java.util.ArrayList;
import java.util.List;

import dao.ScheduleDao;

public class ScheduleLogic {

	public List<ScheduleModel> execute(ScheduleModel sM) {

		ScheduleDao sD = new ScheduleDao();
		
		List<ScheduleModel> sList = new ArrayList<ScheduleModel>();
		sList = sD.findAll(sM);
		
		return sList;
	}
	
//	//削除する（UPDATE）
	public  List<ScheduleModel> delete(ScheduleModel sM){

		List<ScheduleModel> sML = new ArrayList<ScheduleModel>();
		ScheduleDao sD = new ScheduleDao();
		sML = sD.delete(sM);
		
		return sML;
	}
	

}
