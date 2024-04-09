package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.HeatCapacityOfVaporCalculator;

public class HeatCapacityOfVaporImpl implements HeatCapacityOfVaporCalculator {
	
	private final double A;
	private final double B;
	private final double C;
	private final double D;
	
	
	public HeatCapacityOfVaporImpl(double a, double b, double c, double d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
		
	}
	/** Метод для определения теплоёмкости газообразных веществ (DIPPR)
     * Cp = A + B * T + C * T^2 + D * T^3 
     * @param temp in K units
     * @return heat capacity in J/(mol*K) (Дж/(моль*K) units
     */
	@Override
	public double calculate(double temp) {
		return (A + B * temp + C * Math.pow(temp, 2) + D * Math.pow(temp, 3)) * 4.184;
	}
}
