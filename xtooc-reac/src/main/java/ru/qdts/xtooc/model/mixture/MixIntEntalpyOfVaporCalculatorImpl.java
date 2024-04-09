package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.Component;
import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixIntEnthalpyOfVaporCalculator;

public class MixIntEntalpyOfVaporCalculatorImpl implements MixIntEnthalpyOfVaporCalculator {
	
	public MixIntEntalpyOfVaporCalculatorImpl() {
		
	}
	/** Метод для определения энтальпии пара смеси
    *
    * @param temp in K units
    * @return mixEnthalpyOfVap in kal/mole units
    */
	@Override
	public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
	double mixEnthalpyOfVap = 0;
	try {
    for (int i = 0; i < mix.getNumComp(); i++)
        mixEnthalpyOfVap += (mix.getComposition().get(i)) *
                (mix.getComponents().get(i).getintEnthalpyOfVap(temp));
    } catch(PropertyCalculatorNotDefinedException e) {
    	throw new MixPropertyCalculationException("ENTALPY OF VAPOR");
    }
    	return mixEnthalpyOfVap;
		
	}

}
