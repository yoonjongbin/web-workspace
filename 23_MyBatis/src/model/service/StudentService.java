package model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.DepartmentVO;
import model.vo.StudentVO;

public class StudentService {
	public List<StudentVO> showAllStudent(String word){
		System.out.println("service : "+word);
		SqlSession sqlSession = Template.getSqlSession();
		List<StudentVO> list = StudentDAO.getInstance().ShowAllStudent(sqlSession, word);
//		list.get(0).getStudentName();
		sqlSession.close();
		return list;
	}
	
	public List<DepartmentVO> allPrint(){
		SqlSession sqlSession = Template.getSqlSession();
		List<DepartmentVO> list = StudentDAO.getInstance().allPrint(sqlSession);
		//list.get(0).getStudentName();
		sqlSession.close();
		return list;
	}
}
