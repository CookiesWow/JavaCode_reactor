package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixHeatCapacityOfLiquidCalculator;

public class MixHeatCapacityOfLiqCalculatorImpl implements MixHeatCapacityOfLiquidCalculator {
	
	public MixHeatCapacityOfLiqCalculatorImpl() {
		
	}

	/** Метод для определения темлоемкости жидкости смеси
    *
    * @param temp in K units
    * @return mixHeatCapacityOfLiq in kal/(mole * K) units
    */
   public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
       double mixHeatCapacityOfLiq = 0;
       try {
       for (int i = 0; i < mix.getNumComp(); i++)
           mixHeatCapacityOfLiq += mix.getComposition().get(i) *
                   (mix.getComponents().get(i).getHeatCapacityOfLiq(temp));
       } catch (PropertyCalculatorNotDefinedException e) {
       	throw new MixPropertyCalculationException("HEAT CAPACICY OF VAPOR ");
       }
       	return mixHeatCapacityOfLiq;
	}
}