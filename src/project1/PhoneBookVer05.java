package project1;

import java.util.Scanner;

import project1.ver05.PhoneBookManager; //반드시 이 부분을 수정해야 한다.
import project1.ver05.PhoneInfo; //반드시 이 부분을 수정해야 한다.
import project1.ver05.MenuItem;

//메인함수포함, 출발
public class PhoneBookVer05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		//메뉴호출
		while(true) {
			PhoneInfo.printMenu();
			int choice = scanner.nextInt();
			
			switch(choice) {
			case MenuItem.INPUT:
				manager.dataInput(choice);
				break;
			case MenuItem.SEARCH:
				manager.dataSearch();
				break;
			case MenuItem.DELETE:
				manager.dataDelete();
				break;
			case MenuItem.PRINT: 
				manager.dataAllShow();
				break;
			case MenuItem.EXIT:
				System.out.println("프로그램이 종료되었습니다.");
				return; 
			}
			
		}
		
		
	}
	

}
