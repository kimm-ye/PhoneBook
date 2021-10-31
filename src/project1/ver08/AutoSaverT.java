package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;

//자동저장
public class AutoSaverT extends Thread {
	
	PhoneBookManager pm;

	public AutoSaverT(PhoneBookManager pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
			
				for(PhoneInfo pi : pm.set){ 
		            out.println(pi.toString());
				} 
				out.close();
				
				sleep(5000); //5초마다 자동저장
				System.out.println("\n5초마다 txt파일로 자동저장 중입니다.");
			}
		}
		catch (InterruptedException e) {
			//e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("직렬화 예외발생");
			e.printStackTrace();
		}
	}
}
