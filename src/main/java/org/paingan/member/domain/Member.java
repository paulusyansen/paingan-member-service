package org.paingan.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="member_id")
	Long id;
	
	@Column(name="member_name")
	String name;
	
	@Column(name="member_email")
	String email;
	
	int port;
	
	public Member() {
		super();
	}
	
	
	public Member(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", port=" + port + "]";
	}

}
