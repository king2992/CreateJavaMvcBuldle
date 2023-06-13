package createJavaBundle;

import java.util.ArrayList;
import java.util.List;

public class Templates {
	
	/**
	 * 템플릿 파일 목록
	 * @return
	 */
	public ArrayList<String> getTemplates(){
		
		ArrayList<String> t = new ArrayList<String>();
		t.add("JPADomain");
		t.add("JPADomainPK");
		t.add("JPARepository");
		t.add("DTO");
		t.add("MapperInterpace");
		t.add("SearchDto");
		t.add("Service");
		t.add("Controller");
		t.add("MapperXML");
		
		return t;
	}
	
	/**
	 * 생성할 경로, 확장자가 포함되어 있는 목록
	 * @param objectName
	 * @return
	 */
	public ArrayList<String> getTemplatesIncludeExt(String objectName){
		
		ArrayList<String> t = new ArrayList<String>();
		t.add("\\domain\\" + objectName +  ".java");
		t.add("\\domain\\" + objectName +  "PK.java");
		t.add("\\domain\\" + objectName +  "Repository.java");
		t.add("\\dto\\" + objectName +  "Dto.java");
		t.add("\\mapper\\" + objectName +  "Mapper.java");
		t.add("\\dto\\" + objectName +  "SearchDto.java");
		t.add("\\service\\" + objectName +  "Service.java");
		t.add("\\controller\\" + objectName + "Controller.java");
		t.add("\\mapperXML\\" + objectName +  "_SQL.xml");
		
		return t;
	}
}
