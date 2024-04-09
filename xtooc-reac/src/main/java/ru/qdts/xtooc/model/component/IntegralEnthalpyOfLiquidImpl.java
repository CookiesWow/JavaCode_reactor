package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.IntegralEnthalpyOfLiquidCalculator;

public class IntegralEnthalpyOfLiquidImpl implements IntegralEnthalpyOfLiquidCalculator{

	

	
	
	public IntegralEnthalpyOfLiquidImpl() {
		super();
		
		
	
	}
		  /** Метод для определения энтальпии жидкости
	     * @param standard enthalpy of formation in J/mole units,standard enthalpy of vaporization in J/mole units
	     * @param temp in K units
	     * @return enthalpyOfLiq in J/mole units
		 * @throws PropertyCalculatorNotDefinedException 
	     */
		@Override
	    public double calculate (double temp, Component comp) throws PropertyCalculatorNotDefinedException {
	        return comp.getintEnthalpyOfVap(temp) - comp.getEnthalpyOfVaporiz(temp);
	}
}
