package bean;

public class Teacher implements java.io.Serializable{
	private String id;
	private String password;
	private String name;
	private School school;
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public School school() {
		return school;
	}
}
