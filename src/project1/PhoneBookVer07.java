package project1;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.PhoneBookManager; //반드시 이 부분을 수정해야 한다.
import project1.ver07.PhoneInfo; //반드시 이 부분을 수정해야 한다.
import project1.ver07.MenuItem;
import project1.ver06.MenuSelectException;


public class PhoneBookVer07 implements MenuItem  {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager(100);
//		HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
		
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
