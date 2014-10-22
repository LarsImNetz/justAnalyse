package de.hypoport.einarbeitung.toolkit;

public class Zins {

	private final double zins;

	public Zins(double zins){
		this.zins = zins;		
	}
	
	public static Zins valueOf(double zins) {
		return new Zins(zins);
	}
}
