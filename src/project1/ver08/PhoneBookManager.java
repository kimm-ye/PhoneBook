package project1.ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver08.SubMenuItem;
import project1.ver08.PhoneCompanyInfo;
import project1.ver08.PhoneInfo;
import project1.ver08.PhoneSchoolInfo;

public class PhoneBookManager implements Serializable{ //Serializable 인터페이스를 구현하면 JVM에서 해당 객체는 저장하거나 다른 서버로 전송할 수 있도록 해준다

	private PhoneInfo[] myPhoneInfo;
	private int numOfInfo;
	
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	
	public PhoneBookManager(int num) {
		myPhoneInfo = new PhoneInfo[num];
		numOfInfo = 0;
		
		//read는 메인에서 manager부르자마자 바로 호출되야 하니까
		readPhoneBook();
	}
	
	//데이터입력
	public void dataInput(int choice) {
		
		PhoneInfo phoneInfo = null;
		String name, phoneNumber, major, companyName;
		int grade;
		boolean equalCheck = false;

		Scanner scanner = new Scanner(System.in);
		
			System.out.println("\n데이터 입력을 시작합니다.");
			
			System.out.println("1.일반  2.동창   3.회사");
			System.out.print("메뉴를 선택하세요 >>"); 
			int select = scanner.nextInt();
						
			scanner.nextLine(); //버퍼문제로 삽입
			
			System.out.print("이름: "); name = scanner.nextLine();
			System.out.print("전화번호: "); phoneNumber = scanner.nextLine();
			
			
			switch (select) {
			case SubMenuItem.NOMAL:

				phoneInfo= new PhoneInfo(name, phoneNumber);
				
				equalCheck = set.add(phoneInfo); //set을 쓰면 중복일때 false로 반환되기 때문에 boolean으로 비교한다.
				break;
				
			case SubMenuItem.SCHOOL:
				System.out.print("전공: "); major=scanner.nextLine();
				System.out.print("학년: "); grade=scanner.nextInt();
				phoneInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
				
				equalCheck = set.add(phoneInfo);
				break;
				
			case SubMenuItem.COMPANY: 
				System.out.print("회사명: "); companyName=scanner.nextLine();
				phoneInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
				
				equalCheck = set.add(phoneInfo);
				break;
			}
			
			if(equalCheck==false) {
				System.out.println(name + " 정보는 이미 존재합니다.");
				System.out.println("데이터를 덮어쓸까요? Y(y) / N(n)");
				String overWrite = scanner.nextLine();
				
				if("Y".equalsIgnoreCase(overWrite)) {
					set.remove(phoneInfo);
					set.add(phoneInfo);
					System.out.println("해당 데이터로 덮었습니다.\n");
				}
				else if("N".equalsIgnoreCase(overWrite)) {
					System.out.println(phoneInfo +"\n");
				}
				else {
					System.out.println(" Y(y) / N(n) 으로  입력하세요");
				}
			}
			else if(equalCheck==true) {
				System.out.println("데이터입력이 완료되었습니다.");
			}
		}
	
	//데이터 검색
	public void  dataSearch() {
		boolean isFind = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n데이터 검색을 시작합니다.");
		System.out.print("검색할 이름 : ");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(searchName.equals(pi.name)) {
				System.out.println("\n데이터 검색이 완료되었습니다.");
				pi.showPhoneInfo();
				isFind = true;
			}
		}
		if(isFind == false) {
			System.out.println("찾는 데이터가 없습니다.\n");
		}
	}	
	
	//데이터 삭제
	public void  dataDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n데이터 삭제를 시작합니다.");
		System.out.print("삭제할 이름 : ");
		String deleteName = scanner.nextLine();
		
		boolean isDelete = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(deleteName.equals(pi.name)) {
				System.out.println(deleteName + " 데이터가 삭제 되었습니다.\n");
				itr.remove();
				isDelete =true;
			}
		}
		if(isDelete==false) {
			System.out.println("찾는 데이터가 없습니다.\n");
		}
	}
	
	//전체데이터조회
	public void dataAllShow() {
		System.out.println("\n ** 전체정보가 출력되었습니다.**\n ");
		for(PhoneInfo pi : set) {
			pi.showPhoneInfo();
		}
	}
	
	//파일 세이브
	public void savePhoneBook () { //컴퓨터 입장에서 저장하는 건 밖으로 빼내는것
		try {
			System.out.println("\n입력한 데이터를 모두 저장하였습니다.");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/project1/ver08/PhoneBook.obj"));
			
			for(PhoneInfo pi : set) {
				out.writeObject(pi);
			}
			out.close();
			
		}
		catch (Exception e) {
			System.out.println("직렬화 예외발생");
			e.printStackTrace();
		}
	}
	
	//파일 리드
	public void readPhoneBook() { //컴퓨터 입장에서 불러오는 건 안으로 넣는 것
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/project1/ver08/PhoneBook.obj"));
			
			while(true) { //정보 갯수를 정확히 모르니까 while을 사용한다.
				PhoneInfo pi = (PhoneInfo) in.readObject();
				set.add(pi);
				if(pi==null) break; //pi에 들어온 값이 없으면 stop
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("파일없음");
		}
		catch (Exception e) { 
			System.out.println("기존 저장된 데이터를 불러옵니다.");
		}
		System.out.println("주소록 복원 완료");
	}
}

































