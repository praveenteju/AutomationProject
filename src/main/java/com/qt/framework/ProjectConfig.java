package com.qt.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ProjectConfig {
	
	static Properties pro=new Properties();
	static {
		try {
			FileInputStream file=new FileInputStream(new File(System.getProperty("user.dir")+"//src//main//resources//ProjectConfig.properties"));
			pro.load(file);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static String getPropertyValue(String key) {
		return pro.getProperty(key);
	}
}
