package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixDensityCalculator;

public class MixDensityCalculatorImpl implements MixDensityCalculator {

	public MixDensityCalculatorImpl() {
		
	}
	/** Метод для определения плотности смеси
    xсм/pсм = СУММ(xi)/pi
    * @param temp in K units
    * @return density in kmol/cum  units
    */
	@Override
	public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
		double mixDensity = 0;
	    try {
	    	for (int i = 0; i < mix.getNumComp(); i++)
	    		mixDensity += (mix.getComposition().get(i)) / (mix.getComponents().get(i).getDensity(temp));
	    } catch(PropertyCalculatorNotDefinedException e) {
	    	throw new MixPropertyCalculationException("DENSITY");
	    }
	    return 1 / mixDensity;
	}
}
