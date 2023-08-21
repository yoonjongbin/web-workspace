package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.vo.DepartmentVO;
import model.vo.StudentVO;

public class StudentDAO {
	
	private static StudentDAO dao = new StudentDAO();
	
	public StudentDAO() {}
	
	public static StudentDAO getInstance() {
		return dao;
	}
	
	public List<StudentVO> ShowAllStudent(SqlSession sqlSession, String word){
		System.out.println("dao : "+word);
		List<StudentVO> list = sqlSession.selectList("studentMapper.showAllStudent", word);
		for(StudentVO vo : list) {
			System.out.println(vo);
		}
		System.out.println(list.size());
		return sqlSession.selectList("studentMapper.showAllStudent", word);
	}
	
	public List<DepartmentVO> allPrint(SqlSession sqlSession){
		List<DepartmentVO> list = sqlSession.selectList("studentMapper.allPrint");
		for(DepartmentVO vo : list) {
			System.out.println(vo);
		}
		return sqlSession.selectList("studentMapper.allPrint");
	}
	
}
