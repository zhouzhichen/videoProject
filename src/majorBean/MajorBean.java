package majorBean;

public class MajorBean {
	private int type_id;
	private String major;
	
	public MajorBean(int type_id, String major) {
		super();
		this.type_id = type_id;
		this.major = major;
	}
	public MajorBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
