package org.linuxx.moonserver.db.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", unique = false, nullable=false)
	private String name;

	@Column(name = "ort", nullable = false, length = 255)
	private String ort;

	@Column(name = "plz", nullable = true, length = 5)
	private String plz;

	@Column(name = "strasse", nullable = true, length = 255)
	private String strasse;

	@Column(name = "hausnummer", nullable = true, length = 255)
	private String hausnummer;

	@Column(name = "seitJahr", nullable = false)
	private Integer seitJahr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public Integer getSeitJahr() {
		return seitJahr;
	}

	public void setSeitJahr(Integer seitJahr) {
		this.seitJahr = seitJahr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
