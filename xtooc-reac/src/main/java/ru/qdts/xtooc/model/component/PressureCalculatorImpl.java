package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.PressureCalculator;

public class PressureCalculatorImpl implements  PressureCalculator{

	private final double A;
	private final double B;	
	private final double C;	
	
	public PressureCalculatorImpl(double a, double b, double c) {
		super();
		A = a;
		B = b;
		C = c;
	}
	/** Метод для определения давления паров
	 * P = exp^(A - B/(T-C)
	 * @param temp in K units
	 * @return pressure in mm. hq. st units
	 */
	@Override
	
	public double calculate(double temp) {
		return Math.exp(A - B/(temp + C));
	}
}


