package servlet.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.dao.MemberRepository;
import servlet.model.vo.MemberDTO;

public class MemberService {
	
	private MemberRepository repo = new MemberRepository();
	
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		return repo.showAllMember();
	}
	
	public MemberDTO login(String id, String password) throws SQLException{
		return repo.login(id, password);
	}
	
	public MemberDTO findByIdMember(String id) throws SQLException{
		return repo.findByIdMember(id);
	}
	
	public int updateMember(MemberDTO dto) throws SQLException{
		return repo.update(dto);
	}
	
	public void registerMember(MemberDTO dto) throws SQLException{
		repo.registerMember(dto);
	}
}


