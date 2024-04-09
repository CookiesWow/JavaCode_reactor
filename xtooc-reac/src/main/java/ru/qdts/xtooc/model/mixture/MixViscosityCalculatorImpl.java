package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixViscosityCalculator;

public class MixViscosityCalculatorImpl implements MixViscosityCalculator {
	
	public MixViscosityCalculatorImpl() {
		
	}
	/** Метод для определения вязкости смеси
    *
    * @param temp in K units
    * @return mixViscosity in cPs (МПа*с) units
    */
	@Override
	public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
		double mixViscosity = 0;
		try {
	        for (int i = 0; i < mix.getNumComp(); i++)
	            mixViscosity += (mix.getComposition().get(i)) * Math.log10(mix.getComponents().get(i).getViscosity(temp));
	       } catch(PropertyCalculatorNotDefinedException e) {
	    	throw new MixPropertyCalculationException("VISCOSITY");
	}
		 return  Math.pow(mixViscosity, 10);
	}
}
	
