package project1.ver08;

import java.io.Serializable;
import java.util.Scanner;

//데이터, 매니저 작성, 모든기능, 상속 넣기
public class PhoneInfo implements Serializable { //Serializable 인터페이스를 구현하면 JVM에서 해당 객체는 저장하거나 다른 서버로 전송할 수 있도록 해준다

	
	String name; //이름
	String phoneNumber ; //전화번호

	//2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	

	public void showPhoneInfo() {
		System.out.println("====================");
		System.out.println("이름 : " + name); 
		System.out.println("번호 : " + phoneNumber);
	}
	
	public static void printMenu() {
		System.out.println("\n아래 메뉴를 선택하세요");
		System.out.println("-----------------------");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 데이터 저장 옵션");
		System.out.println("6. 프로그램 종료");
		System.out.print(">>"); 
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + " / " + "전화번호 : " + phoneNumber;
	}
	
	@Override
	public int hashCode() {
		int nameHashCode = this.name.hashCode(); //hash코드는 주소값이니까 정수형으로 반환
		return nameHashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo pi = (PhoneInfo)obj; //오브젝트가 더 높으니까 다운캐스팅
		//System.out.print("equals()메서드 호출됨: "); //test용
		if(pi.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
