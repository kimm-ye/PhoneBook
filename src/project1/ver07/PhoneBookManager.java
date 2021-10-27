package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver07.SubMenuItem;
import project1.ver07.PhoneCompanyInfo;
import project1.ver07.PhoneInfo;
import project1.ver07.PhoneSchoolInfo;

public class PhoneBookManager {

	private PhoneInfo[] myPhoneInfo;
	private int numOfInfo;
	
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();

	
	public PhoneBookManager(int num) {
		myPhoneInfo = new PhoneInfo[num];
		numOfInfo = 0;
	}
	
	public void dataInput(int choice) {
		Scanner scanner = new Scanner(System.in);
		
		
		String name, phoneNumber, major, companyName;
		int grade;
		
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
				
				set.add(nomalInfo);
				break;
				
			case SubMenuItem.SCHOOL:
				System.out.print("전공: "); major=scanner.nextLine();
				System.out.print("학년: "); grade=scanner.nextInt();
				
				PhoneSchoolInfo schoolInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
				set.add(schoolInfo);
				break;
				
			case SubMenuItem.COMPANY: 
				System.out.print("회사명: "); companyName=scanner.nextLine();
				PhoneCompanyInfo companyInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
				
				set.add(companyInfo);
				break;
				
			}
			System.out.println("데이터입력이 완료되었습니다.\n");
		}

	public void  dataSearch() {
		boolean isFind = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("검색할 이름 : ");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(searchName.equals(pi.name)) {
				pi.showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.\n");
				isFind = true;
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
		
		boolean deleteIsFind = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(deleteName.equals(pi.name)) {
				System.out.println(deleteName + " 데이터가 삭제 되었습니다.\n");
				set.remove(pi);
				deleteIsFind =true;
			}
		}
		if(deleteIsFind==false) {
			System.out.println("찾는 데이터가 없습니다.");
		}
	}
	
	public void  dataAllShow() {
		
		for(PhoneInfo pi : set) {
			pi.showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}
}