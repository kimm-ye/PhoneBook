package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo{
	String companyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.println("======회사 사람 정보======");
		super.showPhoneInfo();
		System.out.println("회사명: " +companyName);
	}
	

}
