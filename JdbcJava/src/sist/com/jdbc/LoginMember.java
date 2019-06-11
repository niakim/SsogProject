package sist.com.jdbc;

public class LoginMember {
//id	pass	name	addr //CTRL SHIFT Y(¼Ò¹®ÀÚ)
	private String id;
	private String pass;
	private String name;
	private String addr;
	
	public LoginMember() {
		super();
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}




	public String getPass() {
		return pass;
	}




	public void setPass(String pass) {
		this.pass = pass;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddr() {
		return addr;
	}




	public void setAddr(String addr) {
		this.addr = addr;
	}



	@Override
	public String toString() {
		return "LoginMember [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + "]";
	}










	
	
	
	
}
