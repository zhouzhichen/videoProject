package vedioBean;

import java.sql.Time;
import java.sql.Timestamp;

public class VedioBean {
private int vedio_id;
private String vedio_name;
private String vedio_img_url;
private String vedio_url;
private String vedio_msg;
private Timestamp vedio_upload_time;
public Timestamp getVedio_upload_time() {
	return vedio_upload_time;
}
public void setVedio_upload_time(Timestamp vedio_upload_time) {
	this.vedio_upload_time = vedio_upload_time;
}
private int vedio_user_id;
private int vedio_major_id;


public VedioBean() {
	super();
	// TODO Auto-generated constructor stub
}
public VedioBean(int vedio_id, String vedio_name, String vedio_img_url, String vedio_url, String vedio_msg,
		Timestamp vedio_upload_time, int vedio_user_id, int vedio_major_id) {
	super();
	this.vedio_id = vedio_id;
	this.vedio_name = vedio_name;
	this.vedio_img_url = vedio_img_url;
	this.vedio_url = vedio_url;
	this.vedio_msg = vedio_msg;
	this.vedio_upload_time = vedio_upload_time;
	this.vedio_user_id = vedio_user_id;
	this.vedio_major_id = vedio_major_id;
}
public int getVedio_id() {
	return vedio_id;
}
public void setVedio_id(int vedio_id) {
	this.vedio_id = vedio_id;
}
public String getVedio_name() {
	return vedio_name;
}
public void setVedio_name(String vedio_name) {
	this.vedio_name = vedio_name;
}
public String getVedio_img_url() {
	return vedio_img_url;
}
public void setVedio_img_url(String vedio_img_url) {
	this.vedio_img_url = vedio_img_url;
}
public String getVedio_url() {
	return vedio_url;
}
public void setVedio_url(String vedio_url) {
	this.vedio_url = vedio_url;
}
public String getVedio_msg() {
	return vedio_msg;
}
public void setVedio_msg(String vedio_msg) {
	this.vedio_msg = vedio_msg;
}


public int getVedio_user_id() {
	return vedio_user_id;
}
public void setVedio_user_id(int vedio_user_id) {
	this.vedio_user_id = vedio_user_id;
}
public int getVedio_major_id() {
	return vedio_major_id;
}
public void setVedio_major_id(int vedio_major_id) {
	this.vedio_major_id = vedio_major_id;
}




}
