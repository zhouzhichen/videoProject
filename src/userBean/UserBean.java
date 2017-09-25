package userBean;

public class UserBean {
	private int id;
	private String name;
	private String major;
	private int password;
	private String cla;
	private int typeId;
	private String qqname;
	

	public int getId() {
		return id;
	}

	public UserBean() {
	}

	public String getQqname() {
		return qqname;
	}

	public void setQqname(String qqname) {
		this.qqname = qqname;
	}

	public String getCla() {
		return cla;
	}

	public UserBean(int id, String name, String major, int password, String cla, int typeId) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.password = password;
		this.cla = cla;
		this.typeId = typeId;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
