package pattern.model;

import java.sql.SQLException;

public class NoteBookDAO {
	private static NoteBookDAO dao = new NoteBookDAO();

	private NoteBookDAO() {}
	
	public static NoteBookDAO getInstance() {
		return dao;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException{
		// 디비 연결하고 로직 짜고... 했다고 가정하고 구현
		NoteBook notebook = new NoteBook(model, 1000);
		return notebook;
	}
	
}
