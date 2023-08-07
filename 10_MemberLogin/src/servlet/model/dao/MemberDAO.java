package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

public class MemberDAO implements MemberDAOTemplate {
	
	
	
	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩.. ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB 연결 성공");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		rs.close();
	}

	@Override
	public void registerMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER_DTO(ID, PW, NAME, ADDR) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getAddr());
		
		System.out.println(ps.executeUpdate() + "명 가입");
		
		
		closeAll(ps, conn);

	}

	@Override
	public MemberDTO login(String id, String pw) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		ArrayList<MemberDTO> memList = new ArrayList<>();
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO";
		PreparedStatement st = conn.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			
			
//			System.out.println(id + "/" + pw + "/" + name + "/" + addr + "\n");
			
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setAddr(addr);
			
			memList.add(dto);
		}
		
		
		closeAll(rs, st, conn);
		return memList;
	}

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		try {
//			MemberDTO dto = new MemberDTO();
//			dto.setId("USER3");
//			dto.setPw("1234");
//			dto.setName("홍길동");
//			dto.setAddr("111");
//			
//			dao.registerMember(dto);
			
			ArrayList<MemberDTO> list = dao.showAllMember();
			
			for(MemberDTO mem : list) {
				System.out.println(mem.getId()+ "/" + mem.getPw() + "/" + mem.getName() + "/" + mem.getAddr());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
