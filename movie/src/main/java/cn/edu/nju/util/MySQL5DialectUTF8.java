package cn.edu.nju.util;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQL5DialectUTF8  extends MySQL5Dialect{
	
	public String getTableTypeString() {
		return "ENGINE=InnoDB DEFAULT CHARSET=UTF8";
	}

}
