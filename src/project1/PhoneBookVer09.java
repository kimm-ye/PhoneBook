package project1;

import java.util.Scanner;

import project1.ver09.IConnectImpl;
import project1.ver09.PhoneBookManager;
import project1.ver09.PhoneInfo; //반드시 이 부분을 수정해야 한다.

//메인함수포함, 출발
public class PhoneBookVer09  {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		//메뉴호출
		while(true) {
			PhoneInfo.printMenu();
			int choice = scanner.nextInt();
			switch(choice) {
			case 1: //입력
				manager.dataInput();
				break;
			case 2: //검색
				manager.dataSearch();
				break;
			case 3: //삭제
				manager.dataDelete();
				break;
			case 4: //주소록출력
				manager.dataAllShow();
				break;
			case 5: //종료
				System.out.println("\n프로그램을 종료합니다.");
				return; 
			}
		}
	}
}
