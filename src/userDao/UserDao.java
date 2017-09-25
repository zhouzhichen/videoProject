package userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import majorBean.MajorBean;
import userBean.UserBean;
import vedioBean.VedioBean;

public class UserDao {

	public static UserBean login(int password, String qqname) {
		UserBean user = null;
		Connection conn = DBUtil.getConn();
		String sql = "select * from user_info where password=? and qqname=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, password);
			pst.setString(2, qqname);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				user = new UserBean();
				user.setPassword(rs.getInt("password"));
				user.setQqname(rs.getString("qqname"));
				user.setId(rs.getInt("id"));
				user.setTypeId(rs.getInt("type_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static List selectMajor() {
		Connection conn = DBUtil.getConn();
		String sql = "select * from major_tb";
		List list = new ArrayList();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				MajorBean ma = new MajorBean();
				ma.setType_id(rs.getInt("type_id"));
				ma.setMajor(rs.getString("major"));
				list.add(ma);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List selectTecher() {
		Connection conn = DBUtil.getConn();
		String sql = "select * from user_info where type_id=1";
		List list = new ArrayList();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setTypeId(rs.getInt("type_id"));
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setMajor(rs.getString("major"));
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void insert(VedioBean vb) {
		Connection conn = DBUtil.getConn();
	String sql = "insert into vedio_info(Vedio_id,Vedio_name,Vedio_img_url,Vedio_url,Vedio_msg,Vedio_upload_time,Vedio_user_id,Vedio_majro_id) values(0,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, vb.getVedio_name());
			pst.setString(2, vb.getVedio_img_url());
			pst.setString(3, vb.getVedio_url());
			pst.setString(4, vb.getVedio_msg());
			pst.setTimestamp(5, vb.getVedio_upload_time());
			pst.setInt(6, vb.getVedio_user_id());
			pst.setInt(7, vb.getVedio_major_id());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
