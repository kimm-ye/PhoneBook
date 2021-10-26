package project1.ver06;

import java.util.Scanner;

//데이터, 매니저 작성, 모든기능, 상속 넣기
public class PhoneInfo {
	
	String name; //이름
	String phoneNumber ; //전화번호

	//2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름 : " + name); 
		System.out.println("전화번호 : " + phoneNumber);
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
