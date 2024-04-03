package model;

import java.io.Serializable;

public class ScheduleModel implements Serializable{
	
	private int id;
	private String work_name;
	private String work_memo;
	private String start;
	private String end;
	private int user_id;
	private int delete_key;
	
	public ScheduleModel() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public String getWork_memo() {
		return work_memo;
	}

	public void setWork_memo(String work_memo) {
		this.work_memo = work_memo;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDelete_key() {
		return delete_key;
	}

	public void setDelete_key(int delete_key) {
		this.delete_key = delete_key;
	}
	
	
	
	
	
	

}
