package ru.qdts.xtooc.model.mixture;

import java.util.List;

import ru.qdts.xtooc.model.component.Component;
import ru.qdts.xtooc.model.component.BaseComponent.BoilingTemperatureCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.DensityCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.EnthalpyOfVaporizationCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.HeatCapacityOfLiquidCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.HeatCapacityOfVaporCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.IntegralEnthalpyOfLiquidCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.IntegralEnthalpyOfVaporCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.PressureCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.ViscosityCalculator;

public class BaseMixture implements Mixture {
	
	@Override
	public int getNumComp() {
		return components.size();
	}
	
	@Override
	public Composition getComposition() {
		return composition;
	}
	
	@Override
	public List<Component> getComponents() {
		return components;
	}

	// Interface definitions for mixture properties calculation
	
	public static interface MixDensityCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixViscosityCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixEnthalpyOfVaporizationCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixBoilingTemperatureCalculator {
		public double calculate(Mixture mix, double pressure) throws MixPropertyCalculationException;
	}
	
	public static interface MixPressureCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixHeatCapacityOfVaporCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixHeatCapacityOfLiquidCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixIntEnthalpyOfVaporCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	public static interface MixIntEnthalpyOfLiquidCalculator {
		public double calculate(Mixture mix, double temp) throws MixPropertyCalculationException;
	}
	
	private MixDensityCalculator mixDensityCalc;
	private MixViscosityCalculator mixViscosityCalc;
	private MixEnthalpyOfVaporizationCalculator mixEnthalpyOfVaporizationCalc;
	private MixIntEnthalpyOfVaporCalculator mixIntEnthalpyOfVaporCalc; 
	private MixIntEnthalpyOfLiquidCalculator mixIntEnthalpyOfLiquidCalc;
	private MixPressureCalculator mixPressureCalculator;
	private MixBoilingTemperatureCalculator mixBoilingTemperatureCalc;
	private MixHeatCapacityOfVaporCalculator mixHeatCapacityOfVaporCalc;
	private MixHeatCapacityOfLiquidCalculator mixHeatCapacityOfLiquidCalc;
	
	private List<Component> components;
	private Composition composition;
	
	public BaseMixture(List<Component> lc, Composition c, MixDensityCalculator mixDensityCalc, MixViscosityCalculator mixViscosityCalc,
			MixEnthalpyOfVaporizationCalculator mixEnthalpyOfVaporizationCalc, MixBoilingTemperatureCalculator mixBoilingTemperatureCalc,
			MixPressureCalculator mixPressureCalculator, MixHeatCapacityOfVaporCalculator mixHeatCapacityOfVaporCalc,  
			MixHeatCapacityOfLiquidCalculator mixHeatCapacityOfLiquidCalc, MixIntEnthalpyOfVaporCalculator mixIntEnthalpyOfVaporCalc, 
			MixIntEnthalpyOfLiquidCalculator mixIntEnthalpyOfLiquidCalc) {
		components = List.copyOf(lc);
		composition = c;
		this.mixDensityCalc = mixDensityCalc;
		this.mixViscosityCalc = mixViscosityCalc;
		this.mixEnthalpyOfVaporizationCalc = mixEnthalpyOfVaporizationCalc;
		this.mixBoilingTemperatureCalc = mixBoilingTemperatureCalc;
		this.mixPressureCalculator = mixPressureCalculator;
		this.mixHeatCapacityOfVaporCalc = mixHeatCapacityOfVaporCalc;
		this.mixHeatCapacityOfLiquidCalc = mixHeatCapacityOfLiquidCalc;
		this.mixIntEnthalpyOfVaporCalc = mixIntEnthalpyOfVaporCalc;
		this.mixIntEnthalpyOfLiquidCalc =  mixIntEnthalpyOfLiquidCalc;
	}
	
	public static Mixture of(List<Component> compList, Composition compos, MixDensityCalculator mden, MixViscosityCalculator mvis,
			MixEnthalpyOfVaporizationCalculator meviz, MixBoilingTemperatureCalculator mbt,
			MixPressureCalculator mpr, MixHeatCapacityOfVaporCalculator mhv,  
			MixHeatCapacityOfLiquidCalculator mhl, MixIntEnthalpyOfVaporCalculator miev, 
			MixIntEnthalpyOfLiquidCalculator miel) throws MixtureException {
		if(compList == null || compos == null)
			throw new MixtureException("Mixture.of: agruments can't be null");
		if(compList.size() != compos.getNumComp())
			throw new MixtureException("Mixture.of: size of component list and composition must be equal");
		for(Component c : compList)
			if(c == null)
				throw new MixtureException("Mixture.of: component list can't contain null elements");
		return new BaseMixture(compList, compos,  mden, mvis, meviz, mbt, mpr, mhv, mhl, miev, miel);
	}
	
	
	
	@Override
	public double getMixDensity (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixDensityCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixDensityCalc.calculate(this, temp);
	}

	@Override
	public double getMixViscosity(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixViscosityCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixViscosityCalc.calculate(this, temp);
	}

	@Override
	public double getMixEnthalpyOfVaporiz (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixEnthalpyOfVaporizationCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixEnthalpyOfVaporizationCalc.calculate(this, temp);
	}

	@Override
	public double getMixIntEnthalpyOfLiq (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixIntEnthalpyOfLiquidCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixIntEnthalpyOfLiquidCalc.calculate(this, temp);
	}

	@Override
	public double getMixIntEnthalpyOfVap (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixIntEnthalpyOfVaporCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixIntEnthalpyOfVaporCalc.calculate(this, temp);
	}

	@Override
	public double getMixPressure (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixPressureCalculator == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixPressureCalculator.calculate(this, temp);
	}
	
	@Override
	public double getMixBoilingTemperature (double pressure) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixBoilingTemperatureCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixBoilingTemperatureCalc.calculate(this, pressure);
	}

	@Override
	public double getMixHeatCapacityOfVap(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixHeatCapacityOfVaporCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixHeatCapacityOfVaporCalc.calculate(this, temp);
	}

	@Override
	public double getMixHeatCapacityOfLiq(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
		if(mixHeatCapacityOfLiquidCalc == null)
			throw new MixPropertyCalculatorNotDefinedException();
		return mixHeatCapacityOfLiquidCalc.calculate(this, temp);
	}

	public void setMixDensityCalc(MixDensityCalculatorImpl mdc) {
		// TODO Auto-generated method stub
		
	}

	public void setMixViscosityCalc(MixViscosityCalculatorImpl mvc) {
		// TODO Auto-generated method stub
		
	}

}
