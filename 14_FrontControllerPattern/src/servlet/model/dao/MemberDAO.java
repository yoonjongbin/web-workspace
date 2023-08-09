package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberVO;
import servlet.model.vo.MemberVO;

public class MemberDAO implements MemberDAOTemplate {
	
	// 싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체지향적 설계! 싱글톤 패턴은 객체지향적 설계 원칙을 준수 -> 중앙에서 처리!
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 * */
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩!");
		} catch (ClassNotFoundException e) {}
	}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
//	public MemberDAO() {
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("db 연결!!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER_DTO(id, pw, name, addr) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
		
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO WHERE id=? AND pw=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("pw"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("addr"));
		}
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("pw"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("addr"));
		}
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<MemberVO> list = new ArrayList<>();
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("pw"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("addr"));
			list.add(vo);
		}
		closeAll(rs, ps, conn);
		return list;
	}
	
	@Override
	public int update(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE MEMBER_DTO SET PW = ?, NAME = ?, ADDR = ? WHERE ID = ?";
		
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getPassword());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getId());
		
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setId("USER1");
		vo.setPassword("1234");
		vo.setName("김미경");
		vo.setAddress("경기 광주");
//		vo.setId("user1");
//		vo.setPassword("user1");
//		vo.setName("김미경");
//		vo.setAddress("경기 광주");
		
		try {
			System.out.println("skskskskskskks");
			//dao.registerMember(vo);
			
//			vo = dao.login("USER1", "1234");

//			System.out.println("name : " + vo.getName());
//			System.out.println("address : " + vo.getAddress());
			if(dao.update(vo) == 1) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			}
		
			
		} catch (SQLException e) {}
	}
	

}