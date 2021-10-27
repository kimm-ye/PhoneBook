package project1.ver08;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver08.SubMenuItem;
import project1.ver08.PhoneCompanyInfo;
import project1.ver08.PhoneInfo;
import project1.ver08.PhoneSchoolInfo;

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
		
			System.out.println("\n데이터 입력을 시작합니다.");
			
			System.out.println("1.일반  2.동창  3.회사");
			System.out.print("메뉴를 선택하세요 >>"); 
			int select = scanner.nextInt();
						
			scanner.nextLine(); //버퍼문제로 삽입
			
			System.out.print("이름: "); name = scanner.nextLine();
			System.out.print("전화번호: "); phoneNumber = scanner.nextLine();
			
			switch (select) {
			case SubMenuItem.NOMAL:

				PhoneInfo nomalInfo = new PhoneInfo(name, phoneNumber);
				
				equalsCheck(name); //중복되면 여기서 이전 데이터 삭제를 하고
				set.add(nomalInfo); //새로운 데이터를 추가
				break;
				
			case SubMenuItem.SCHOOL:
				System.out.print("전공: "); major=scanner.nextLine();
				System.out.print("학년: "); grade=scanner.nextInt();
				PhoneSchoolInfo schoolInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
				
				equalsCheck(name);
				set.add(schoolInfo);
				break;
				
			case SubMenuItem.COMPANY: 
				System.out.print("회사명: "); companyName=scanner.nextLine();
				PhoneCompanyInfo companyInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
				
				equalsCheck(name);
				set.add(companyInfo);
				break;
				
			}
			System.out.println("데이터입력이 완료되었습니다.\n");
		}
	
	public boolean equalsCheck(String name) {
		Iterator<PhoneInfo> itr = set.iterator();
		Scanner scanner = new Scanner(System.in);
		
		
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(name.equals(pi.name)) {
				
				while(true) {
					System.out.println(name + " 정보는 이미 존재합니다.");
					System.out.println("데이터를 덮어쓸까요? Y(y) / N(n)");
					String overWrite = scanner.nextLine();
					if("Y".equalsIgnoreCase(overWrite)) {
						itr.remove();
						System.out.println("해당 데이터로 덮었습니다.\n");
						break;
					}
					else if("N".equalsIgnoreCase(overWrite)) {
						pi.showPhoneInfo();
						break;
					}
					else {
						System.out.println(" Y(y) / N(n) 으로  입력하세요");
					}
				}	
			}
		}
		return false;
	}

	public void  dataSearch() {
		boolean isFind = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n데이터 검색을 시작합니다.");
		System.out.print("검색할 이름 : ");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(searchName.equals(pi.name)) {
				System.out.println("\n데이터 검색이 완료되었습니다.");
				System.out.println(pi +"\n");
				isFind = true;
			}
		}
		if(isFind == false) {
			System.out.println("찾는 데이터가 없습니다.\n");
		}
	}	
		
	
	public void  dataDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n데이터 삭제를 시작합니다.");
		System.out.print("삭제할 이름 : ");
		String deleteName = scanner.nextLine();
		
		boolean isDelete = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(deleteName.equals(pi.name)) {
				System.out.println(deleteName + " 데이터가 삭제 되었습니다.\n");
				itr.remove();
				isDelete =true;
			}
		}
		if(isDelete==false) {
			System.out.println("찾는 데이터가 없습니다.\n");
		}
	}
	
	public void dataAllShow() {
		System.out.println("\n ** 전체정보가 출력되었습니다.**\n ");
		for(PhoneInfo pi : set) {
			pi.showPhoneInfo();
		}
	}
}