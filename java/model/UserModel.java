package model;

public class UserModel {
	
	private int id;
	private String pass;
	private String name;
	private int edit;
	private int department_key;
	private int delete_key;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEdit() {
		return edit;
	}
	public void setEdit(int edit) {
		this.edit = edit;
	}
	public int getDepartment_key() {
		return department_key;
	}
	public void setDepartment_key(int department_key) {
		this.department_key = department_key;
	}
	public int getDelete_key() {
		return delete_key;
	}
	public void setDelete_key(int delete_key) {
		this.delete_key = delete_key;
	}

}
