package project1.ver03;

import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] myPhoneInfo;
	private int numOfInfo;
	
	public PhoneBookManager(int num) {
		myPhoneInfo = new PhoneInfo[num];
		numOfInfo = 0;
	}
	
	public void dataInput() {
		System.out.println("데이터입력을 시작합니다.");
		
		Scanner scanner = new Scanner(System.in);
		String name, phoneNumber, birthday;
		
		System.out.print("이름:"); name = scanner.nextLine();
		System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
		System.out.print("생년월일:"); birthday = scanner.nextLine();
		
		System.out.println("데이터입력이 완료되었습니다.\n");
		myPhoneInfo[numOfInfo++] = new PhoneInfo(name, phoneNumber, birthday);
	}
	
	public void  dataSearch() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("검색할 이름 : ");
		String searchName = scanner.nextLine();
		
		boolean isFind = false;
		for(int i=0; i<numOfInfo; i++) {
			if(searchName.compareTo(myPhoneInfo[i].name)==0) {
				myPhoneInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.\n");
				isFind =true;
			}
		}
		if(isFind == false) {
			System.out.println("찾는 데이터가 없습니다.\n");
		}
	}
	
	public void  dataDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("삭제할 이름 : ");
		String deleteName = scanner.nextLine();
		
		int deleteIndex = -1;
		for(int i=0; i<numOfInfo; i++) {
			if(deleteName.compareTo(myPhoneInfo[i].name)==0) {
				myPhoneInfo[i] = null;
				deleteIndex = i;
				numOfInfo--;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제할 데이터가 없습니다.\n");
		}
		else {
			for(int i=deleteIndex; i<numOfInfo; i++) {
				myPhoneInfo[i] = myPhoneInfo[i+1];
			}
			System.out.println(deleteName + " 정보가 삭제 되었습니다.\n");
		}
		
	}
	
	public void  dataAllShow() {
		for(int i=0; i<numOfInfo; i++) {
			myPhoneInfo[i].showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}
	
	
}
