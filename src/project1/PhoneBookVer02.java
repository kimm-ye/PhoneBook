package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo; //반드시 이 부분을 수정해야 한다.

//메인함수포함, 출발
public class PhoneBookVer02   {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String name, phoneNumber, birthday;
		
		//메뉴호출
		while(true) {
			System.out.println("아래 메뉴를 선택하세요");
			System.out.println("1. 데이터입력");
			System.out.println("2. 프로그램종료");
			System.out.print("선택 : ");
			int choice = scanner.nextInt();
			
			if(choice ==1) {
				scanner.nextLine();
				System.out.print("이름:"); name = scanner.nextLine();
				System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
				System.out.print("생년월일:"); birthday = scanner.nextLine();
				
				PhoneInfo p1 = new PhoneInfo(name, phoneNumber,birthday);
				p1.showPhoneInfo();
			}
			else if(choice ==2) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(2);
			}
		}
	}
}
