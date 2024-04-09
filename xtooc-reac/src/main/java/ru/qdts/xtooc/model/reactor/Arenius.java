package ru.qdts.xtooc.model.reactor;

public class Arenius {

	
	public static double calculate (double A, double Ea, double temp) {
		return A * Math.exp(-Ea/(8.314 * temp));
	}

}
