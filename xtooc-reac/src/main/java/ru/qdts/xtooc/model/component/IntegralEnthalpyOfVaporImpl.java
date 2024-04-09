package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.IntegralEnthalpyOfVaporCalculator;

public class IntegralEnthalpyOfVaporImpl implements IntegralEnthalpyOfVaporCalculator   {

	private final double A;
	private final double B;
	private final double C;
	private final double D;
	
	
	
	public IntegralEnthalpyOfVaporImpl(double a, double b, double c, double d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
		
		
		
	
	}
	/** Метод для определения энтальпии пара 
     * @param standard enthalpy of formation in J/mole units
     * @param temp in K units
     * @return enthalpyOfVap in J/mole units
	 * @throws PropertyCalculatorNotDefinedException 
     */
	@Override
	 public double calculate(double temp, Component comp) throws PropertyCalculatorNotDefinedException {
        return comp.getStEnthalpy() + A * (temp - 298) + B * (1/2) *
                (Math.pow(temp, 2) - Math.pow(298, 2)) + C * (1/3) *
                (Math.pow(temp, 3) - Math.pow(298, 3)) + D * (1/4) *
                (Math.pow(temp, 4) - Math.pow(298, 4));
	}
}
