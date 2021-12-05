package tip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipDAO {
	private Connection conn;
	private ResultSet rs;
	
	public TipDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "jsp";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		
	}
	public int getNext() {
		String SQL = "SELECT tipID FROM TIP ORDER BY tipID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //첫번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int write(String tipTitle, String userID, String tipContent) {
		String SQL = "INSERT INTO TIP VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, tipTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, tipContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
		
	}
	
	public ArrayList<Tip> getList(int pageNumber){
		String SQL = "SELECT * FROM TIP WHERE tipID < ? AND tipAvailable = 1 ORDER BY tipID DESC LIMIT 10";
		ArrayList<Tip> list = new ArrayList<Tip>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10 );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Tip tip = new Tip();
				tip.setTipID(rs.getInt(1));
				tip.setTipTitle(rs.getString(2));
				tip.setUserID(rs.getString(3));
				tip.setTipDate(rs.getString(4));
				tip.setTipContent(rs.getString(5));
				tip.setTipAvailable(rs.getInt(6));
				list.add(tip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 데이터베이스 오류
	}

	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM TIP WHERE tipID < ? AND tipAvailable = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10 );
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // 데이터베이스 오류
		}
	
	
	public Tip getTip(int tipID) {
		String SQL = "SELECT * FROM TIP WHERE tipID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, tipID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Tip tip = new Tip();
				tip.setTipID(rs.getInt(1));
				tip.setTipTitle(rs.getString(2));
				tip.setUserID(rs.getString(3));
				tip.setTipDate(rs.getString(4));
				tip.setTipContent(rs.getString(5));
				tip.setTipAvailable(rs.getInt(6));
				return tip;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public int update(int tipID, String tipTitle, String tipContent) {
		String SQL = "UPDATE TIP SET tipTitle = ?, tipContent = ? WHERE tipID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, tipTitle);
			pstmt.setString(2, tipContent);
			pstmt.setInt(3, tipID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int delete(int tipID) {
		String SQL = "UPDATE TIP SET tipAvailable = 0 WHERE tipID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, tipID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	}
