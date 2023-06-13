package createJavaBundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Path currentPath = Paths.get("");
	//static String resultPath = currentPath.toAbsolutePath().toString().concat("\\src\\result\\");
	static String resultPath = "C:\\UFSP_BUNDLE\\result\\";
	static String templatePath = "C:\\UFSP_BUNDLE\\template\\";
	
	public static void main(String[] args){
		init();
	}
	
	/**
	 * 입력 값 세팅
	 */
	public static void init() {
		Util util = new Util();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 이름을 입력하세요.");
		InputData.writer = sc.next();
		
		System.out.println("패키지명을 입력하세요.");
		InputData.packageName = sc.next();
		util.makePackageDir(InputData.packageName);
		
		System.out.println("테이블명을 입력해주세요. ex) UFSD_BIZ_MST");
		InputData.tableName = sc.next();
		
		System.out.println("권한을 입력해주세요. ex) admin OR user");
		InputData.auth = sc.next();
		
		System.out.println("도메인 한글명을 입력하세요. ex) 사업마스터");
		InputData.objectKorName = sc.next();
		
		System.out.println("도메인의 키 이름을 입력하세요. ex) bizCd");
		InputData.objectKeyName = sc.next();
		
		System.out.println("도메인 키의 한글명을 입력하세요. ex) 사업코드");
		InputData.objectKeyKorName = sc.next();
		
		System.out.println("도메인 키의 자료형을 입력하세요. ex) String");
		InputData.objectKeyType = sc.next();
		
		InputData.objectName = util.getObjectName(InputData.tableName);
		InputData.instanceName = util.getInstanceName(InputData.tableName);
		
		convertFileTemplate();
		
		System.out.println("아무 키나 누르면 종료됩니다.");
	}
	
	/**
	 * 템플릿 파일을 입력받은 값으로 출력
	 */
	public static void convertFileTemplate() {
		Util util = new Util();
		String date = util.getNowDate();
		
		Templates templates = new Templates();
		
		ArrayList<String> fileTemplates = templates.getTemplates();
		
		String filePath = templatePath;
		DB db = new DB();
		String javaDto = db.getJavaDto(InputData.tableName);
		String javaDomain = db.getJavaEntity(InputData.tableName);
		
		try {
			
			for(int i = 0; i < fileTemplates.size(); i++) {
				String fileContent = "";
				File file = new File(filePath + fileTemplates.get(i)+".text");
				
				if (file.exists()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
					
					String line = null;
					while ((line = reader.readLine()) != null) {
						
						line = line.replace("${ObjectName}", InputData.objectName);
						line = line.replace("${ObjectKorName}", InputData.objectKorName);
						line = line.replace("${DATE}", date);
						line = line.replace("${TableName}", InputData.tableName);
						line = line.replace("${PackageName}", InputData.packageName);
						line = line.replace("${auth}", InputData.auth);
						line = line.replace("${writer}", InputData.writer);
						
						line = line.replace("${instanceName}", InputData.instanceName);
						line = line.replace("${ObjectKeyName}", InputData.objectKeyName);
						line = line.replace("${ObjectKeyKorName}", InputData.objectKeyKorName);
						line = line.replace("${ObjectKeyType}", InputData.objectKeyType);
						if(fileTemplates.get(i).equals("JPADomain")) {
							line = line.replace("${JavaDomain}", javaDomain);
						}
						if(fileTemplates.get(i).equals("DTO")) {
							line = line.replace("${JavaDto}", javaDto);
						}
	
						fileContent += line + "\r\n";
	
					}
	
					reader.close();
				}
	
				writeFileTemplate(fileContent, InputData.packageName, InputData.objectName, i);
			}
		}catch(IOException e) {
			System.out.println("자바 번들 생성을 실패하였습니다. 관리자에게 문의하세요.");
		}
	}
	
	/**
	 * 최종 파일 생성
	 * @param fileContent
	 * @param packageName
	 * @param objectName
	 * @param i
	 */
	public static void writeFileTemplate(String fileContent, String packageName, String objectName, int i) {
		
		Templates templates = new Templates();
		
		ArrayList<String> fileTemplatesIncludeExt = templates.getTemplatesIncludeExt(objectName);
		
		String filePath = resultPath + packageName;
		try {
			File file = new File(filePath + fileTemplatesIncludeExt.get(i));
			
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
	        //BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
	        
	        writer.write(fileContent);
	        
	        writer.flush();
	        writer.close();
	        
	        System.out.println(filePath + fileTemplatesIncludeExt.get(i).concat("파일 생성을 완료하였습니다."));
	        
		}catch(IOException e) {
			System.out.println("파일 생성을 실패했습니다. 관리자에게 문의하세요.");
		}

		
	}
}
