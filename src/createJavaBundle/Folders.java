package createJavaBundle;

import java.util.ArrayList;
import java.util.List;

public class Folders {
	
	/**
	 * 생성할 폴더 목록
	 * @return
	 */
	public ArrayList<String> getFolders(){
		
		ArrayList<String> t = new ArrayList<String>();
		t.add("controller");
		t.add("service");
		t.add("domain");
		t.add("dto");
		t.add("mapper");
		t.add("mapperXML");
		
		return t;
	}
}
