package org.trsm.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Visitor implements Serializable{
	private Collection<Programme> programme;
	
	//@OneToMany(mappedBy ="Visitor")

	public Visitor(Collection<Programme> programme) {
		super();
		this.programme = programme;
	}

	public Visitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Programme> getProgramme() {
		return programme;
	}

	public void setProgramme(Collection<Programme> programme) {
		this.programme = programme;
	}

}
