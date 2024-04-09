package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.Component;
import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixEnthalpyOfVaporizationCalculator;

public class MixEntalpyOfVaporizationCalculatorImpl implements  MixEnthalpyOfVaporizationCalculator {
	
	 public MixEntalpyOfVaporizationCalculatorImpl() {
		 
	 }
	  /** Метод для определения энтальпии парообразования смеси
    * tempCritical in K units
    * @param temp in K units
    * @return mixEnthalpyOfVaporiz in kal/mole units
    */
	@Override
   public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException {
       double mixEnthalpyOfVaporiz = 0;
       try {
       for (int i = 0; i < mix.getNumComp(); i++)
           mixEnthalpyOfVaporiz += (mix.getComposition().get(i)) *
                   (mix.getComponents().get(i).getEnthalpyOfVaporiz(temp));
       } catch(PropertyCalculatorNotDefinedException e) {
	    	throw new MixPropertyCalculationException("ETALPY OF VAPORIZATION");
       }
       return mixEnthalpyOfVaporiz;
	
	}

}
