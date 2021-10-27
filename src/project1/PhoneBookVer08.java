package project1;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.PhoneBookManager; //반드시 이 부분을 수정해야 한다.
import project1.ver08.PhoneInfo; //반드시 이 부분을 수정해야 한다.
import project1.ver08.MenuItem;
import project1.ver06.MenuSelectException;


public class PhoneBookVer08 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager(100);
		
		//메뉴호출
		while(true) {
			PhoneInfo.printMenu();

			try {
				int choice = scanner.nextInt();
				if(choice <0 || choice >6) {
					MenuSelectException mse = new MenuSelectException();
					throw mse;
				}
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
					manager.savePhoneBook();
					return; //return은 메인함수의 종료
				}
			}
			catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("숫자로만 입력해야 합니다.\n");
			}
			catch (NullPointerException e) {
				System.out.println("검색결과가 없습니다.");
			}
		}
	}
}
