package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.Component;
import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixIntEnthalpyOfLiquidCalculator;

public class MixIntEntalpyOfLiquidCalculatorImpl implements MixIntEnthalpyOfLiquidCalculator{

	public MixIntEntalpyOfLiquidCalculatorImpl() {
		
	}
	/** Метод для определения энтальпии жидкости смеси
    *
    * @param temp in K units
    * @return mixEnthalpyOfVap in kal/mole units
    */
	
	@Override
	public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
	double mixEnthalpyOfLiq = 0;
	try {
    for (int i = 0; i < mix.getNumComp(); i++)
        mixEnthalpyOfLiq += (mix.getComposition().get(i)) *
                (mix.getComponents().get(i).getintEnthalpyOfLiq(temp));
    } catch(PropertyCalculatorNotDefinedException e) {
    	throw new MixPropertyCalculationException("ENTALPY OF LiQUID (INTEGRAL)");
    }
    	return mixEnthalpyOfLiq;

	}

}
