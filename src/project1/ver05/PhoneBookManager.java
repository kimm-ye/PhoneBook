package project1.ver05;

import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] myPhoneInfo;
	private int numOfInfo;
	
	public PhoneBookManager(int num) {
		myPhoneInfo = new PhoneInfo[num];
		numOfInfo = 0;
	}
	
	public void dataInput(int choice) {
		Scanner scanner = new Scanner(System.in);
		
		
		String name, phoneNumber, major, companyName;
		int grade;

		while(true) {
			System.out.println("데이터 입력을 시작합니다.");
			
			System.out.println("1.일반  2.동창  3.회사");
			System.out.print("메뉴를 선택하세요 >>"); 
			int select = scanner.nextInt();
						
			scanner.nextLine(); //버퍼문제로 삽입
			System.out.print("이름: "); name = scanner.nextLine();
			System.out.print("전화번호: "); phoneNumber = scanner.nextLine();
			
			switch (select) {
			case SubMenuItem.NOMAL:
				PhoneInfo nomalInfo = new PhoneInfo(name, phoneNumber);
				myPhoneInfo[numOfInfo++] = nomalInfo;
				break;
				
			case SubMenuItem.SCHOOL:
				System.out.print("전공: "); major=scanner.nextLine();
				System.out.print("학년: "); grade=scanner.nextInt();
				PhoneSchoolInfo schoolInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
				myPhoneInfo[numOfInfo++] = schoolInfo;
				break;
				
			case SubMenuItem.COMPANY: 
				System.out.print("회사명: "); companyName=scanner.nextLine();
				PhoneCompanyInfo companyInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
				myPhoneInfo[numOfInfo++] = companyInfo;
				break;
				
			default:
				break;
			}
			System.out.println("데이터입력이 완료되었습니다.\n");
			break;
		}
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
