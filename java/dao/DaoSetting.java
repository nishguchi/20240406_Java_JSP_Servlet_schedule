package dao;

public class DaoSetting {

	//DB接続情報
	private final String JDBCSet ="jdbc:mysql://localhost:3306/webp2";
	private final String DBId = "root";
	private final String DBPass = "mysql";
	
	//ゲッター
	public String getJDBCSet() {
		return JDBCSet;
	}
	public String getDBId() {
		return DBId;
	}
	public String getDBPass() {
		return DBPass;
	}
}
