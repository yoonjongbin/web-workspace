package servlet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.vo.MemberVO;
import servlet.model.vo.MemberVO;

public interface MemberDAOTemplate {
	 Connection getConnection() throws SQLException;
	 
	 void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	 void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	 
	 void registerMember(MemberVO dto) throws SQLException;
	 MemberVO login(String id, String pw) throws SQLException;
	 MemberVO findByIdMember(String id) throws SQLException;
	 ArrayList<MemberVO> showAllMember() throws SQLException;
	 int update(MemberVO dto) throws SQLException;
	 
	 
}
