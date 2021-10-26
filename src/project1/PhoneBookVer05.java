package project1;

import java.util.Scanner;

import project1.ver05.PhoneBookManager; //반드시 이 부분을 수정해야 한다.
import project1.ver05.PhoneInfo; //반드시 이 부분을 수정해야 한다.
import project1.ver05.MenuItem;

//메인함수포함, 출발
public class PhoneBookVer05 implements MenuItem  {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		//메뉴호출
		while(true) {
			PhoneInfo.printMenu();
			int choice = scanner.nextInt();
			
			switch(choice) {
			case INPUT:
				manager.dataInput(choice);
				break;
			case SEARCH:
				manager.dataSearch();
				break;
			case DELETE:
				manager.dataDelete();
				break;
			case PRINT: 
				manager.dataAllShow();
				break;
			case EXIT:
				System.out.println("프로그램이 종료되었습니다.");
				return; 
			}
			
		}
		
		
	}
	

}
