package model.vo;

public class StudentVO {
	private String student_No;
	private String student_Name;
	private String student_Address;
	private DepartmentVO department;
	public StudentVO() {}
	
	public StudentVO(String student_No, String student_Name, String student_Address, DepartmentVO department) {
		super();
		this.student_No = student_No;
		this.student_Name = student_Name;
		this.student_Address = student_Address;
		this.department = department;
	}
	
	
	public String getStudentNo() {
		return student_No;
	}
	public void setStudentNo(String student_No) {
		this.student_No = student_No;
	}
	public String getStudentName() {
		return student_Name;
	}
	public void setStudentName(String student_Name) {
		this.student_Name = student_Name;
	}
	public String getStudentAddr() {
		return student_Address;
	}
	public void setStudentAddr(String student_Address) {
		this.student_Address = student_Address;
	}
	public DepartmentVO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}
	
	
	@Override
	public String toString() {
		return "StudentVO [studentNo=" + student_No + ", studentName=" + student_Name + ", studentAddr=" + student_Address
				+ ", department=" + department + "]";
	}
	
	
	
	
}
