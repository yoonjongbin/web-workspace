package member.model.vo;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String addr;
	
	public MemberVO() {
	}

	public MemberVO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.pw = password;
		this.name = name;
		this.addr = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + "]";
	}
	
	

	
	
	
	
	
}
