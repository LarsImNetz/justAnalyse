package org.linuxx.moonserver.db.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Try")
// @Cacheable(false)
public class TryEntity {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "vorname", nullable = true, length = 255)
	private String vorname;

	@Temporal(TemporalType.DATE)
	private Date erstellt;
	
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "TryEntity [id=" + id + ", name=" + name + ", vorname=" + vorname + ", date=" + erstellt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null)
				? 0
				: id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TryEntity other = (TryEntity) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(final String vorname) {
		this.vorname = vorname;
	}

	public Date getErstellt() {
		return erstellt;
	}

	public void setErstellt(final Date erstellt) {
		this.erstellt = erstellt;
	}

}
