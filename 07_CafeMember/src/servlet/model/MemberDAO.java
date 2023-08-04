package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate {
	private ArrayList<MemberVO> list = new ArrayList<>();
	
	public MemberDAO() {
		// 1. 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		// 2. 데이터베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection...!!");

		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		// 5. close 닫기
		ps.close();
		conn.close();

	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		rs.close();
	}

	@Override
	public void insertMem(MemberVO vo) throws SQLException {

		Connection conn = getConnection();

		// 3. Statement 객체 생성

		String query = "INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES(?, ?, ?)"; // or properties 생성
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());

		// 4. 쿼리문 실행
		System.out.println(ps.executeUpdate() + "명 가입");

		closeAll(ps, conn);

	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		list.clear();

		// 3. Statement 객체 생성

		String query = "SELECT * FROM MEMBER";
		PreparedStatement st = conn.prepareStatement(query);
		ResultSet rs = st.executeQuery();
//		System.out.println(rs);
		
		while(rs.next()) {
			String name = rs.getString("name");
			int age = Integer.parseInt(rs.getString("age"));
			String addr = rs.getString("addr");
			
			
			System.out.print(name + "/" + age + "/" + addr + "\n");
			list.add(new MemberVO(name, age, addr));
		}
		
		closeAll(rs, st, conn);
		return list;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
	
		// 3. Statement 객체 생성

		String query = "SELECT * FROM MEMBER WHERE NAME = ?";
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String userName = rs.getString("name");
			int age = Integer.parseInt(rs.getString("age"));
			String addr = rs.getString("addr");
			
			
			MemberVO member = new MemberVO(userName, age, addr);
			return member;
		}
		
		closeAll(rs, st, conn);
		
		return null;
	}

	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();

		try {
//			dao.insertMem(new MemberVO("다다다", 13, "ㅇㄹㅇㄴ"));
			
//			ArrayList<MemberVO> list = dao.showAllMember();
//			for(MemberVO member : list) {
//				System.out.println(member);
//			}
			
			if(dao.findByNameMember("감가가") != null) {
				MemberVO member = dao.findByNameMember("감가가");
				System.out.println(member);
			} else {
				System.out.println("해당 유저가 없습니다.");
			}
			
			
		} catch (SQLException e) {

			System.out.println("가입 실패!! : " + e.getMessage());
		}

	}

}
