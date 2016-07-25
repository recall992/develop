package org.hwl.annotation;

@UserAnnotation(value="haifeng")
public class TestAnnotation {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
