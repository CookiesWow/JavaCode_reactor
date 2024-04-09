package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.ViscosityCalculator;

public class ViscosityCalculatorImpl implements ViscosityCalculator {

	private final double A;
	private final double B;
	private final double C;
	
	public ViscosityCalculatorImpl(double a, double b, double c) {
		super();
		A = a;
		B = b;
		C = c;
	}

	/** Метод для определения вязкости по уравнению Фогеля
     * η = e^(A+(B/(C+T))
     * @param temp in K units
     * @return viscosity in cPs (МПа*с) units
     */
	@Override
	public double calculate(double temp) {
		return Math.exp(A +(B/(C+temp)));
	}

}
