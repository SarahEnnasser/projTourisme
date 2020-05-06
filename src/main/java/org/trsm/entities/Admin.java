package org.trsm.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Admin implements Serializable{
	@Id @GeneratedValue
	private int id_Admin;
	private String matricule;
	
	
	@OneToMany(mappedBy ="Admin")// fetch = FetchType.LAZY  par  defaut , cvd quand je demande a hibernate de charger un admin, il va charger que ses infos 
	private Collection<Programme> programme;
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Collection<Programme> getProgramme() {
		return programme;
	}

	public void setProgramme(Collection<Programme> programme) {
		this.programme = programme;
	}

	public Admin(String matricule, Collection<Programme> programme) {
		super();
		this.matricule = matricule;
		this.programme = programme;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
