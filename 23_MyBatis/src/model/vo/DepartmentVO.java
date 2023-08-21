package model.vo;

public class DepartmentVO {
	private String department_No;
	private String department_Name;
	private String category;
	public DepartmentVO() {}
	public DepartmentVO(String deptNo, String deptName, String category) {
		super();
		this.department_No = deptNo;
		this.department_Name = deptName;
		this.category = category;
	}
	
	
	public String getDeptNo() {
		return department_No;
	}
	public void setDeptNo(String deptNo) {
		this.department_No = deptNo;
	}
	public String getDeptName() {
		return department_Name;
	}
	public void setDeptName(String deptName) {
		this.department_Name = deptName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "DepartmentVO [deptNo=" + department_No + ", deptName=" + department_Name + ", category=" + category + "]";
	}
	
}
