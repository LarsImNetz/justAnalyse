package de.hypoport.einarbeitung.guice;


public class SampleClass implements ISampleClass {

	String value;

	public SampleClass() {
		value = "ein";
		System.out.println("C'Tor TestClass init value to " + value);
	}

	@Override
	public String setValue(String a) {
		this.value = a;
		System.out.println("setValue to " + value);
		return this.value;
	}

	@Override
	public String getValue() {
		System.out.println("getValue " + value);
		return value;
	}

}
