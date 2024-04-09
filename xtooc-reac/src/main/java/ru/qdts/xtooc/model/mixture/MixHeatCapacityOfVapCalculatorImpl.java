package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixHeatCapacityOfVaporCalculator;

public class MixHeatCapacityOfVapCalculatorImpl implements MixHeatCapacityOfVaporCalculator{

	public MixHeatCapacityOfVapCalculatorImpl() {
		
	}
	/** Метод для определения темлоемкости пара смеси
    *
    * @param temp in K units
    * @return mixHeatCapacityOfVap in kal/(mole * K) units
    */
   public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
       double mixHeatCapacityOfVap = 0;
       try {
       for (int i = 0; i < mix.getNumComp(); i++)
           mixHeatCapacityOfVap += mix.getComposition().get(i) *
                   (mix.getComponents().get(i).getHeatCapacityOfVap(temp));
       } catch (PropertyCalculatorNotDefinedException e) {
       	throw new MixPropertyCalculationException("HEAT CAPACICY OF VAPOR ");
       }
       	return mixHeatCapacityOfVap;
	}
}
