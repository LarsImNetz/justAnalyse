package org.linuxx.moonserver.db.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "name")
public class NameEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "vorname", nullable = true, length = 255)
	private String vorname;

	@Temporal(TemporalType.DATE)
	@Column(name = "geburtsdatum"/* , nullable = false */)
	private Date geburtsdatum;

	@Column(name = "address", unique = true, nullable = false)
	private String address;

	@OneToMany(targetEntity = AddressEntity.class)
	@JoinColumn(name = "name", referencedColumnName = "address")
	private List<AddressEntity> addressList;

	public List<AddressEntity> getAddressList() {
		return addressList;
	}

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

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// public List<AddressEntity> getAddressList() {
	// return addressList;
	// }
	//
	// public void setAddressList(List<AddressEntity> addressList) {
	// this.addressList = addressList;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		NameEntity other = (NameEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
