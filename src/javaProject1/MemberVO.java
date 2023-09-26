package javaProject1;

public class MemberVO {
	private int idx;
	private String name;
	private String nickName;
	private String email;
	private int age;
	private int password;
	private String phoneNum;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", name=" + name + ", nickName=" + nickName + ", email=" + email + ", age="
				+ age + ", password=" + password + ", phoneNum=" + phoneNum + "]";
	}
	
}
