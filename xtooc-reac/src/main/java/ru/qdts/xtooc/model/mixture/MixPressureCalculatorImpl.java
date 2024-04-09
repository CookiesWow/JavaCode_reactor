package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixPressureCalculator;

public class MixPressureCalculatorImpl implements MixPressureCalculator {

	public MixPressureCalculatorImpl() {
		
	}
	/** Метод для определения давления смеси
    *
    * @param temp in K units
    * @return mixPressure in Pa units
    */
	@Override
   public double calculate (Mixture mix, double temp) throws MixPropertyCalculationException {
       double mixPressure = 0;
       try {
       for (int i = 0; i < mix.getNumComp(); i++)
           mixPressure += mix.getComposition().get(i) *
                   (mix.getComponents().get(i).getPressure(temp));
	} catch (PropertyCalculatorNotDefinedException e) {
    	throw new MixPropertyCalculationException("PRESSURE");
	}
       return mixPressure;
	}

}
