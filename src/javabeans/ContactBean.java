//Eduard Springer

package javabeans;

import java.io.Serializable;

public class ContactBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String betreff;
	private String nachricht; 
	private String name;
	private String email;
	private Boolean status;
	private int id; 
		
	public String getBetreff() {
		return betreff;
	}
	public void setBetreff(String betreff) {
		this.betreff = betreff;
	}
	public String getNachricht() {
		return nachricht;
	}
	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public int getId() {
		return id; 
	}
	public void setId(int id) {
		this.id = id; 
	}
}