package bookstore.Models;

public class Etudiant {
	private Long id;
	private String fname;
	private String lastname;
	private String email;
	
	
	
	
	
	public Etudiant() {
		super();
		// tt TODO Auto-generated constructor stub
	}
	public Etudiant(Long id, String fname, String lastname, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lastname = lastname;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
