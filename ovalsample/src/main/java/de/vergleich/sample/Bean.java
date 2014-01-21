package de.vergleich.sample;

import java.io.Serializable;

public class Bean implements Serializable{
	// @NotNull
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
