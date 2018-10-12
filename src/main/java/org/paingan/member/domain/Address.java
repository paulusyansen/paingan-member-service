package org.paingan.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id")
	Long id;
	
	@Column(name="address_title")
	String title;
	
	@Column(name="address_detail")
	String detail;
	
	int port;

	public Address(Long id, String title, String detail, int port) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", title=" + title + ", detail=" + detail + ", port=" + port + "]";
	}

}
