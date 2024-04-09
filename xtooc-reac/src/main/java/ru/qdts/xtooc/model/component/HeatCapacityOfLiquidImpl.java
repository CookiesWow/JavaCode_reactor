package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.HeatCapacityOfLiquidCalculator;

public class HeatCapacityOfLiquidImpl implements HeatCapacityOfLiquidCalculator{
	
	private final double A;
	private final double B;
	private final double C;
	private final double D;
	private final double E;
	
	public HeatCapacityOfLiquidImpl(double a, double b, double c, double d, double e) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
		E = e;
	}
	/** Метод для определения теплоёмкости жидких веществ 
     * Cp = A + B * T + C * T^2 + D * T^3 + E * T^4
     * @param temp in K units
     * @return heat capacity in J/(mol*K) (Дж/(моль*K) units
     */
	@Override
	public double calculate(double temp) {
		return (A + B * temp + C * Math.pow(temp, 2) + D * Math.pow(temp, 3) + E * Math.pow(temp, 4))/1000;
	}
}
