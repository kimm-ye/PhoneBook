package project1.ver06;

public class MenuSelectException extends Exception{

	public MenuSelectException() {
		super("\n※경고※ 1~5까지의 숫자만 입력하십시오.");
	}
}
