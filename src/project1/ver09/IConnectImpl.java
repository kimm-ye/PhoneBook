package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect {
	
	public Connection con; //특정 데이터 원본과 연결된 커넥션으로 SQL문장을 정의하고 실행시킬수 있는 statement객체를 생성할때 사용
	public PreparedStatement psmt; //sql문장을 미리 컴파일러 할 수 있도록 개선
	public ResultSet rs; 
	public Statement stmt;
	
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");	
	}
	
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public IConnectImpl(String driver, String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(driver);
			connect(user,pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user,pass);
		}
		catch (SQLException e) {
			System.out.println("데이터베이스 연결오류");
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute() {
		//하는일 없음
	}
	
	@Override
	public void close() {
		try {
			if(con!=null)con.close();
			if(psmt != null)psmt.close();
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			System.out.println("자원반납완료");
		}
		catch (Exception e) {
			System.out.println("자원반납시 오류발생");
			e.printStackTrace();
		}
	}

	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print(title + "을(를) 입력(exit->종료):");
		String inputStr = scan.nextLine();
		
		if("EXIT".equalsIgnoreCase(inputStr))	{
			System.out.println("프로그램을 종료합니다.");
			close();
			//프로그램 자체가 즉시 종료된다.
			System.exit(0);
		}
		
		return inputStr;
	}
}





































