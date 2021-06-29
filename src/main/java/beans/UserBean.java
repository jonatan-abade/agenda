package beans;

public class UserBean {
	private Integer id;
	private String name;
	private String email;
	private String password;

	public boolean login(String email, String password) {
		if (this.email.equals("admin@admin.com") && this.email.equals("admin123")) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
