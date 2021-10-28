package project1.ver09;

import java.util.Scanner;

//데이터, 매니저 작성, 모든기능, 상속 넣기
public class PhoneInfo {
	
	String name; //이름
	String phoneNumber ; //전화번호
	String birthday; //생년월일

	//3개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	//2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지않음";
	}
	
	public void showPhoneInfo() {
		System.out.println("======입력된 정보 출력======");
		System.out.println("이름 : " + name); 
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("생년월일 : " + birthday); 
		System.out.println();
	}
	
	public static void printMenu() {
		System.out.println("아래 메뉴를 선택하세요");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택 : ");
	}
	

	
	
}
