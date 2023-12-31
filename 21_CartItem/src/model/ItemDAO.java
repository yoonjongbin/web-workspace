package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate {

	private static ItemDAO dao = new ItemDAO();
	
	public ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 완료!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ItemDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("db연결 완료!!");
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
	public ArrayList<Item> getAllItem() throws SQLException {
		
		ArrayList<Item> items = new ArrayList<>();
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			items.add(new Item(rs.getInt("ITEM_ID"), 
								rs.getString("ITEM_NAME"), 
								rs.getInt("PRICE"), 
								rs.getString("DESCRIPTION"), 
								rs.getString("PICTURE_URL"), 
								rs.getInt("COUNT")));	// 컬럼명 대신 숫자를 사용할 수 있다.(ex. rs.getInt("ITEM_ID") -> rs.getInt(1))
		}
		
		closeAll(rs, ps, conn);
		
		return items;
		
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM ITEM WHERE ITEM_ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		ResultSet rs = ps.executeQuery();
		Item item = null;
		
		if(rs.next()) {
			item = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
		}
		
		closeAll(rs, ps, conn);
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {

		Connection conn = getConnection();
		
		String query = "UPDATE ITEM SET COUNT = COUNT+1 WHERE ITEM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		
		
		int row = ps.executeUpdate();
		boolean result = false;
		
		if(row>0) result = true;
		
		closeAll(ps, conn);
		
		return result;
	}
	
	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		
		try {
			ArrayList<Item> items = dao.getAllItem();
			
			if(!items.isEmpty()) {
				for(Item item : items) {
					System.out.println(item);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
