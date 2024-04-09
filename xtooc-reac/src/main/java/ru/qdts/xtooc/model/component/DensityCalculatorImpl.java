package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.DensityCalculator;

public class DensityCalculatorImpl implements DensityCalculator {
	
	
	private final double A;
	private final double B;	
	private final double C;	
	private final double D;
	
	public DensityCalculatorImpl(double a, double b, double c, double d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
	}
		
	/** Метод для определения плотности
     * ρ = (A)/(B^[1+(1-T/C)^D])
     * @param temp in K units
     * @return density in kg/m3 units
     */
	@Override
	public double calculate(double temp) {
	return (A / (Math.pow(B, 1 + Math.pow((1 - (temp / C)) , D))));
	}
}
