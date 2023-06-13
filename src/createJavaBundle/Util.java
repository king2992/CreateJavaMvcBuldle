package createJavaBundle;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Util {
	static Path currentPath = Paths.get("");
	//static String resultPath = currentPath.toAbsolutePath().toString().concat("\\src\\result\\");
	static String resultPath = "C:\\UFSP_BUNDLE\\result\\";
	/**
	 * 패키지 경로 생성
	 * @param packageName
	 */
	public void makePackageDir(String packageName) {
		String path = resultPath + packageName;
		File Folder = new File(path);
		
		if (!Folder.exists()) {
			try {
				Folder.mkdir();
				makeDir(packageName);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	/**
	 * 폴더 생성(Controller, Service 등등)
	 * @param packageName
	 */
	public void makeDir(String packageName) {
		Folders folders = new Folders();
		
		ArrayList<String> folderList = folders.getFolders();
		
		for(int i = 0; i < folderList.size(); i++) {
			
			String path = resultPath + packageName.concat("\\") + folderList.get(i);
			File Folder = new File(path);

			if (!Folder.exists()) {
				try {
					Folder.mkdir();
				} catch (Exception e) {
					e.getStackTrace();
				}
			} else {
				System.out.println("폴더 생성 실패.");
			}
		}
	}
	
	/**
	 * 현재 일자 가져오기
	 * @return
	 */
	public String getNowDate() {
		
		LocalDate now = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String formatedNow = now.format(formatter);
		
		return formatedNow;
	}
	
	/**
	 * 입력 받은 테이블명으로 객체 이름 생성
	 * @param tblName
	 * @return
	 */
	public String getObjectName(String tblName) {
		
		String temp[] = tblName.split("_");
		
		String rstObjectName = "";
		
		for(int i = 1; i < temp.length; i++) {
			
			String convertString = temp[i].substring(0,1) + temp[i].substring(1).toLowerCase();
			
			rstObjectName += convertString;
		}
		return rstObjectName;
		
	}
	
	/**
	 * 입력 받은 테이블명으로 인스턴스네임 생성
	 * @param tblName
	 * @return
	 */
	public String getInstanceName(String tblName) {
		
		String temp[] = tblName.split("_");
		
		String rstObjectName = "";
		
		for(int i = 1; i < temp.length; i++) {
			if(i == 1) {
				String convertString = temp[i].toLowerCase();
				rstObjectName += convertString;
			}else {
				String convertString = temp[i].substring(0,1) + temp[i].substring(1).toLowerCase();
				rstObjectName += convertString;
			}
		}
		return rstObjectName;
		
	}
}
