package createJavaBundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	final String  CONFIG_PROPERTIES_FILE = "C:\\UFSP_BUNDLE\\DB.properties";
    
    public String getDbInfo(String param) {
    	 FileInputStream file;
    	try {
    		Properties mainProperties = new Properties();
    		file = new FileInputStream(CONFIG_PROPERTIES_FILE);
    		mainProperties.load(file);
    		file.close();
    		
    		String rtn = mainProperties.getProperty(param);
    		return rtn;
    	}catch(FileNotFoundException f) {
    		System.out.println("프로퍼티스 파일을 찾을 수 없습니다.");
    	}catch(IOException e) {
    		System.out.println("IOException !");
    	}
    	 return "";
    }
}
