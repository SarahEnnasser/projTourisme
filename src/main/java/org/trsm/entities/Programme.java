package org.trsm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Programme implements Serializable {
	private int id;
	private Boolean type;
	private String description;
	@ManyToOne
	@JoinColumn(name=id_Admin)

	public Programme(int id, Boolean type, String description, Admin admin, Visitor visitor) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.admin = admin;
		this.visitor = visitor;
	}
	public Programme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	private Admin admin;
	private Visitor visitor;

}
