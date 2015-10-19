package cn.itcast.i_aop3_anno;

public class User {
	// 一般的类型
	private Long id;
	private String name = "无名氏";

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
