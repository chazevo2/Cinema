package Cinema.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.DBConnect;

public class MovieDaoImpl implements MovieDao {
	private DBConnect db;
	private Connection conn;

	public MovieDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Movie m) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into Movie values (seq_movie_no.nextval,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMname());
			pstmt.setString(2, m.getStory());
			pstmt.setInt(3, m.getRuntime());
			pstmt.setString(4, m.getGenre());
			pstmt.setInt(5, m.getRate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(Movie m) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update Movie set story=? where mno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getStory());
			pstmt.setInt(2, m.getMno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void delete(int mno) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete from Movie where mno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public Movie select(int mno) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select * from Movie where mno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Movie> selectByName(String mname) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Movie> list = new ArrayList<Movie>();
		conn = db.getConnection();
		String sql = "select * from Movie where mname like '%" + mname + "%'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Movie> selectByStory(String story) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Movie> list = new ArrayList<Movie>();
		conn = db.getConnection();
		String sql = "select * from Movie where story like '%" + story + "%'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Movie> selectByGenre(String genre) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Movie> list = new ArrayList<Movie>();
		conn = db.getConnection();
		String sql = "select * from Movie where genre = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Movie> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Movie> list = new ArrayList<Movie>();
		conn = db.getConnection();
		String sql = "select * from movie";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

}
