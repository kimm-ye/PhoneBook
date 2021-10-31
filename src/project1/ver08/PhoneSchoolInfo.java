package project1.ver08;

public class PhoneSchoolInfo extends PhoneInfo {
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("구분 : 동창");
		System.out.println("전공 : " +major);
		System.out.println("학년 : " +grade);
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + " / 전화번호 : " + phoneNumber +  " / 전공 : " + major + " / 학년 : " + grade;
	}
	
}
