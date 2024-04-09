package ru.qdts.xtooc.model.mixture;

import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.BaseMixture.MixBoilingTemperatureCalculator;

public class MixBoilingTemperatureCalculatorImpl implements MixBoilingTemperatureCalculator {

	public MixBoilingTemperatureCalculatorImpl() {
		
	}
	/** Метод для определения температуры кипения смеси смеси
    *
    * @param pressure in K units
    * @return mixBoilingTemperature in Pa units
    */
	@Override
	   public double calculate (Mixture mix, double pressure) throws MixPropertyCalculationException {
	       double mixBoilingTemperature = 0;
	       try {
	       for (int i = 0; i < mix.getNumComp(); i++)
	           mixBoilingTemperature += mix.getComposition().get(i) *
	                   (mix.getComponents().get(i).getBoilingTemperature(pressure));
		} catch (PropertyCalculatorNotDefinedException e) {
	    	throw new MixPropertyCalculationException("BOILING TEMPERATURE");
		}
	       return mixBoilingTemperature;
		}

	}
