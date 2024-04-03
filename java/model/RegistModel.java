package model;

public class RegistModel {
	
	private String work_name;
	private String work_memo;
	private String start;
	private String end;
	private int user_id;


	public RegistModel(
			String work_name,
			String work_memo,
			String start,
			String end,
			int user_id
			) {
		
		this.work_name = work_name;
		this.work_memo = work_memo;
		this.start = start;
		this.end = end;
		this.user_id = user_id;
		
	}

	public String getWork_name() {
		return work_name;
	}
	public String getWork_memo() {
		return work_memo;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	
}
