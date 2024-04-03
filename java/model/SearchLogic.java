package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import dao.SearchDao;

public class SearchLogic {
	
	
	public List<ScheduleModel> serch(ScheduleModel sM) throws ParseException {
		
		SearchDao sD = new SearchDao();
		List<ScheduleModel> sML = new ArrayList<ScheduleModel>();
		
		sML = sD.search(sM); //ParseException
		
		return sML;
		
	}
	
}
