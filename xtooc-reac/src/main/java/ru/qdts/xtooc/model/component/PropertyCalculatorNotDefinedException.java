package ru.qdts.xtooc.model.component;

@SuppressWarnings("serial")
public class PropertyCalculatorNotDefinedException extends Exception {
	private String propertyName;
	
	public PropertyCalculatorNotDefinedException(String propName) {
		super("Calculator for property [" + propName + "] is not defined");
		propertyName = propName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
}
