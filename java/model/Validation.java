package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.cj.util.StringUtils;

public class Validation {

	//https://qiita.com/suema0331/items/5dde9f91671100a83905
	//https://qiita.com/grrrr/items/0b35b5c1c98eebfa5128
	//https://www.javadrive.jp/start/regex/index6.html
	//http://funcs.org/1283
	
	//文字列 空判定
	public boolean isEmpty(String word) {
		boolean bool = false;
		if(!(word.isEmpty())){
			bool = true;
		}
		return bool;
	}
	
	//文字列 0文字より大きい
//	public boolean length(String word) {		
//		boolean bool = false;
//		if(word.length() <=0) {
//			bool = true;
//		}
//		return bool;
//	}
	
	//文字列 9桁以下
	public boolean length9(String num) {		
		boolean bool = false;
		if(num.length() <= 9) {
			bool = true;
		}
		return bool;
	}
	
	
	//文字列 15桁以下
	public boolean length15(String num) {		
		boolean bool = false;
		if(num.length() <= 15) {
			bool = true;
		}
		return bool;
	}
	
	//文字列 3文字以上25桁以下
	public boolean length25(String num) {		
		boolean bool = false;
		if(num.length() >=3 && num.length() <= 25) {
			bool = true;
		}
		return bool;
	}
	
	
	//文字列 25桁以下
	public boolean length25Max(String num) {		
		boolean bool = false;
		if(num.length() <= 25) {
			bool = true;
		}
		return bool;
	}
	
	
	//文字列 600桁以下
	public boolean length600Max(String num) {		
		boolean bool = false;
		if(num.length() <= 600) {
			bool = true;
		}
		return bool;
	}
	

	//数字か
	public boolean isNumeric(String word) {
		boolean bool = false;
		bool = StringUtils.isStrictlyNumeric(word);
		return bool;		
	}
	

	//半角英数字、指定記号か （数字・アルファベット・シンボル）
	public boolean isNumAS(String word) {
		boolean bool = false;
		Pattern pat = Pattern.compile("^[0-9a-zA-Z!-/:-@-`{-~]+$"); 
		Matcher mat = pat.matcher(word);
		bool =mat.matches(); //mat.find();
		return bool;
	}
	//2024年03月26日20:01
	
	//年月日か
	public boolean CalToDate(String word) {
		boolean bool = false;
		Pattern pat = Pattern.compile("^[0-9]{4}年[0-9]{2}月[0-9]{2}日[0-9]{2}:[0-9]{2}$"); 
		Matcher mat = pat.matcher(word);
		bool =mat.matches(); //mat.find();
		return bool;
	}
	
	
	
	
	
	
	
}
