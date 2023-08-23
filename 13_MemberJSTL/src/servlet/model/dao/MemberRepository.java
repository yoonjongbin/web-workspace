package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

public class MemberRepository implements MemberDAOTemplate {
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
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
	public void registerMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER_DTO(id, pw, name, addr) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getAddress());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
		
	}

	@Override
	public MemberDTO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO WHERE id=? AND pw=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("addr"));
		}
		closeAll(rs, ps, conn);
		return dto;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("addr"));
		}
		closeAll(rs, ps, conn);
		return dto;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER_DTO";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<MemberDTO> list = new ArrayList<>();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("addr"));
			list.add(dto);
		}
//		for(MemberDTO member : list) {
//			System.out.println("DAOMember : " + member);
//		}
		closeAll(rs, ps, conn);
		return list;
	}
	
//	public void updateMember(MemberDTO dto) throws SQLException {
//		Connection conn = getConnection();
//		
//		String query = "UPDATE member SET password=?, name=?, address=? WHERE id=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, dto.getPassword());
//		ps.setString(2, dto.getName());
//		ps.setString(3, dto.getAddress());
//		ps.setString(4, dto.getId());
//		
//		ps.executeUpdate();
//		closeAll(ps, conn);
//	}

	@Override
	public int update(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE member SET password=?, name=?, address=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dto.getPassword());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getAddress());
		ps.setString(4, dto.getId());
		
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		
		return result;
	}
	
	public static void main(String[] args) {
		MemberRepository repo = new MemberRepository();
		
		try {
			ArrayList<MemberDTO> list = repo.showAllMember();
			
			for(MemberDTO member : list) {
				System.out.println(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}