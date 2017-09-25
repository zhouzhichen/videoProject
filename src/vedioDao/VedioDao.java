package vedioDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import majorBean.MajorBean;
import vedioBean.VedioBean;

public class VedioDao {
	public static List select(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from vedio_info where vedio_user_id =" + id;
		List list = new ArrayList();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				VedioBean ma = new VedioBean();
				ma.setVedio_user_id(rs.getInt("vedio_user_id"));
				ma.setVedio_name(rs.getString("vedio_name"));
				ma.setVedio_img_url(rs.getString("vedio_img_url"));
				ma.setVedio_url(rs.getString("vedio_url"));
				ma.setVedio_msg(rs.getString("vedio_msg"));
				ma.setVedio_upload_time(rs.getTimestamp("vedio_upload_time"));
				ma.setVedio_major_id(rs.getInt("vedio_majro_id"));
				list.add(ma);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
