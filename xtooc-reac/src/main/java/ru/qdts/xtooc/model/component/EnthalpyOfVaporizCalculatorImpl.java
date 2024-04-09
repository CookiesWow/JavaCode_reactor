package ru.qdts.xtooc.model.component;


import ru.qdts.xtooc.model.component.BaseComponent.EnthalpyOfVaporizationCalculator;

public class EnthalpyOfVaporizCalculatorImpl implements EnthalpyOfVaporizationCalculator {
	
	private final double A;
	private final double B;
	private final double C;
	private final double D;
	
	
	public EnthalpyOfVaporizCalculatorImpl(double a, double b, double c, double d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
		
		
	}
	
	
	/** Метод для определения теплоты испарения (PPDS)
     * ΔHv = a*(1-Tr)^(b + c*Tr + d*Tr*Tr), Tr = T/Tкр
     * t = 1- (T/Tс)
     * @param temp in K units
     * @param tempCritical in K units
     * @return enthalpy of vaporization in J/mol (Дж/моль) units
     */
	@Override
	public double calculate(double temp, Component comp) {
		double t = temp/comp.getTempCritical();
		return  A * ( Math.pow((1 - t), B + C * t + D * Math.pow(t, 2))) * 4.184;
		
	}
}
