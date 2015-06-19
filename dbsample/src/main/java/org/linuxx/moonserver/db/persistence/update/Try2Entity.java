package org.linuxx.moonserver.db.persistence.update;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Try")
// @Cacheable(false)
public class Try2Entity {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	// @Column(name="vorname", nullable = true, length = 255)
	// private String vorname;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Try2Entity other = (Try2Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	// public String getVorname() {
	// return vorname;
	// }
	//
	// public void setVorname(String vorname) {
	// this.vorname = vorname;
	// }

}
