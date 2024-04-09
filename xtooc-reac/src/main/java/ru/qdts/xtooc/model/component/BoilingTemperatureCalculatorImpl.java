package ru.qdts.xtooc.model.component;

import ru.qdts.xtooc.model.component.BaseComponent.BoilingTemperatureCalculator;

public class BoilingTemperatureCalculatorImpl implements BoilingTemperatureCalculator {
	
	
	private final double A;
	private final double B; 
	private final double C;
	

	public BoilingTemperatureCalculatorImpl(double a, double b, double c) {
		super();
		A = a;
		B = b;
		C = c;
	}
	/** Метод для определения температуры кипения жидкости при давлении P
     * Tboil = ((1/Tst) - ((R*ln(P/Patm))/Hst)^-1
     * @param stBoilTemp in K units
     * @param stEnthalpyOfVaporiz in J/mol (Дж/моль) units
     * @param PressureAtm in Pa
     * @return boiling temperature in K  units
     */


	@Override
	public double calculate(double pressure) {
		return (B/(- Math.log(pressure) + A)) - C;
		
	}
}
