package project1.ver09;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PhoneBookManager extends IConnectImpl{

	private PhoneInfo[] myPhoneInfo;
	private int numOfInfo;

	
	public PhoneBookManager(int num) {
		super("kosmo", "1234");
		
		myPhoneInfo = new PhoneInfo[num];
		numOfInfo = 0;
	}
	
	public void dataInput() {
		System.out.println("데이터입력을 시작합니다.\n");
		
		try {
			String query = "INSERT INTO phonebook_tb VALUES ((seq_phonebook.NEXTVAL), ?, ?, ?)";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, scanValue("이름"));
			psmt.setString(2, scanValue("전화번호"));
			psmt.setString(3, scanValue("생년월일"));
			
			System.out.println("\n" +psmt.executeUpdate() + "행이 입력되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close(); //여기서 close해버리면 실행할때마다 다시 새로 접속해야한다.
//		}
	}
	
	public void  dataSearch() {
		try {
			Statement stmt = con.createStatement();
			String searchName = scanValue("검색할 이름");
			
			String sql = "SELECT idx, name, p_Num, "
					+ "	to_char(birth, 'yyyy-mm-dd') birth "
					+ " FROM phonebook_tb "
					+ " WHERE name LIKE '%" + searchName + "%' ";
			
			rs = stmt.executeQuery(sql);
			
			boolean isFind = false;
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				String p_Num = rs.getString(3);
				String birth = rs.getString(4);
				
				System.out.println("\n["+searchName+"] 정보를 출력합니다.\n");
				System.out.printf(" No.%d%n 이름:%s%n 전화번호:%s%n 생년월일:%s%n", idx, name, p_Num, birth);
				System.out.println();
				isFind = true;
			}
			if(isFind==false) {
				System.out.println("\n[" + searchName+ "] 데이터가 없습니다.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  dataDelete() {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, scanValue("삭제할 이름"));
			System.out.println("\n" +psmt.executeUpdate() +"행이 삭제 되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  dataAllShow() {
		try {
			Statement stmt = con.createStatement();
			
			String sql = "SELECT idx, name, p_Num, "
					+ "	to_char(birth, 'yyyy-mm-dd') birth "
					+ " FROM phonebook_tb "
					+ " ORDER BY idx ASC ";
			rs = stmt.executeQuery(sql);
			
			System.out.println("\n전체정보가 출력되었습니다.\n");
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				String p_Num = rs.getString(3);
				String birth = rs.getString(4);
				
				System.out.printf(" No.%d%n 이름:%s%n 전화번호:%s%n 생년월일:%s%n", idx, name, p_Num, birth);
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exit() {
		close();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	