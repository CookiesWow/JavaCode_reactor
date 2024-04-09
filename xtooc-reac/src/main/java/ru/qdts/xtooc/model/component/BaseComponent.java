package ru.qdts.xtooc.model.component;

public class BaseComponent implements Component {

    protected final String name;
    protected final double molecularMass;
    protected final double stBoilTemp;
    protected final double tempCritical;
    protected final double stEnthalpy;
    protected final double stEnthalpyOfVaporiz;
    
	public static interface DensityCalculator {
		public double calculate(double temp);
	}
	
	public static interface ViscosityCalculator {
		public double calculate(double temp);
	}
	
	public static interface EnthalpyOfVaporizationCalculator {
		public double calculate(double temp, Component comp);
	}
	
	public static interface BoilingTemperatureCalculator {
		public double calculate(double pressure);
	}
	
	public static interface PressureCalculator {
		public double calculate(double temp);
	}
	
	public static interface HeatCapacityOfVaporCalculator {
		public double calculate(double temp);
	}
	
	public static interface HeatCapacityOfLiquidCalculator {
		public double calculate(double temp);
	}
	
	public static interface IntegralEnthalpyOfVaporCalculator {
		public double calculate(double temp, Component comp) throws PropertyCalculatorNotDefinedException;
	}
	
	public static interface IntegralEnthalpyOfLiquidCalculator {
		public double calculate(double temp, Component comp) throws PropertyCalculatorNotDefinedException;
	}
	
	
	private DensityCalculator densityCalc;
	private ViscosityCalculator viscosityCalc;
	private EnthalpyOfVaporizationCalculator enthOfVzationCalc;
	private BoilingTemperatureCalculator boilTempCalc;
	private PressureCalculator pressureCalc;
	private HeatCapacityOfVaporCalculator heatCapOfVCalc;
	private HeatCapacityOfLiquidCalculator heatCapOfLCalc;
	private IntegralEnthalpyOfVaporCalculator intenthOfVCalc;
	private IntegralEnthalpyOfLiquidCalculator intenthOfLCalc; 

	
	public BaseComponent(String name, double molecMass, double tempCritical, double stBoilTemp, double stEnthalpy,
			double stEnthalpyOfVaporiz,  DensityCalculator densityCalc, ViscosityCalculator viscosityCalc,
			EnthalpyOfVaporizationCalculator enthOfVzationCalc, BoilingTemperatureCalculator boilTempCalc,
			PressureCalculator pressureCalc, HeatCapacityOfVaporCalculator heatCapOfVCalc,  
			HeatCapacityOfLiquidCalculator heatCapOfLCalc, IntegralEnthalpyOfVaporCalculator intenthOfVCalc, 
			IntegralEnthalpyOfLiquidCalculator intenthOfLCalc) {
		super();
		this.name = name;
		this.molecularMass = molecMass;
		this.tempCritical = tempCritical;
		this.stBoilTemp = stBoilTemp;
		this.stEnthalpy = stEnthalpy;
		this.stEnthalpyOfVaporiz = stEnthalpyOfVaporiz;
		this.densityCalc = densityCalc;
		this.viscosityCalc = viscosityCalc;
		this.enthOfVzationCalc = enthOfVzationCalc;
		this.boilTempCalc = boilTempCalc;
		this.pressureCalc = pressureCalc;
		this.heatCapOfVCalc = heatCapOfVCalc;
		this.heatCapOfLCalc = heatCapOfLCalc;
		this.intenthOfVCalc = intenthOfVCalc;
		this.intenthOfLCalc = intenthOfLCalc;
		
	}

	@Override
	public double getDensity(double temp) throws PropertyCalculatorNotDefinedException {
		if(densityCalc == null)
			throw new PropertyCalculatorNotDefinedException("DENSITY");
		
		return densityCalc.calculate(temp);
	}

	@Override
	public double getViscosity(double temp) throws PropertyCalculatorNotDefinedException {
		if(viscosityCalc == null)
			throw new PropertyCalculatorNotDefinedException("VISCOSITY");
		
		return viscosityCalc.calculate(temp);
	}

	@Override
	public double getEnthalpyOfVaporiz(double temp) throws PropertyCalculatorNotDefinedException {
		if(enthOfVzationCalc == null)
			throw new PropertyCalculatorNotDefinedException("ENTALPY OF VAPORIZ");
		
		return enthOfVzationCalc.calculate(temp, this);
	}

	@Override
	public double getBoilingTemperature (double pressure) throws PropertyCalculatorNotDefinedException {
		if(boilTempCalc == null)
			throw new PropertyCalculatorNotDefinedException("BOIL TEMPERATURE");	
		
		return boilTempCalc.calculate(pressure);
	}

	@Override
	public double getPressure(double temp) throws PropertyCalculatorNotDefinedException {
		if(pressureCalc == null)
			throw new PropertyCalculatorNotDefinedException("PRESSURE");	
		
		return pressureCalc.calculate(temp);
	}

	@Override
	public double getHeatCapacityOfVap(double temp) throws PropertyCalculatorNotDefinedException {
		if(heatCapOfVCalc == null)
			throw new PropertyCalculatorNotDefinedException("HEAT CAPACICY OF VAPOR");	
		
		return heatCapOfVCalc.calculate(temp);
	}
	
	@Override
	public double getHeatCapacityOfLiq(double temp) throws PropertyCalculatorNotDefinedException {
		if(heatCapOfLCalc == null)
			throw new PropertyCalculatorNotDefinedException("HEAT CAPACICY OF LIQUID");	
		
		return heatCapOfLCalc.calculate(temp);
	}

	@Override
	public double getintEnthalpyOfVap(double temp) throws PropertyCalculatorNotDefinedException {
		if(intenthOfVCalc == null)
			throw new PropertyCalculatorNotDefinedException("ENTHALPY OF VAPOR");	
		return intenthOfVCalc.calculate(temp, this);
	}

	@Override
	public double getintEnthalpyOfLiq(double temp) throws PropertyCalculatorNotDefinedException {
		if(intenthOfLCalc == null)
			throw new PropertyCalculatorNotDefinedException("ENTHALPY OF LIQUID");
		return intenthOfLCalc.calculate(temp, this);
	}
	
	@Override
	public String getName() {
		return name;
	}

//	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMolecularMass() {
		return molecularMass;
	}

//	@Override
	public void setMolecMass(double molecMass) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getTempCritical() {
		return tempCritical;
	}

//	@Override
	public void setTempCritical(double tempCritical) {
		// TODO Auto-generated method stub

	}
	@Override
	public double getStBoilTemp() {
		return stBoilTemp;
	}

//	@Override
	public void setStBoilTemp(double stBoilTemp) {
		// TODO Auto-generated method stub
	}
	@Override
	public double getStEnthalpy() {
		return stEnthalpy;
	}

//	@Override
	public void setStEnthalpy(double stEnthalpy) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getStEnthalpyOfVaporiz() {
		return stEnthalpyOfVaporiz;
	}

//	@Override
	public void setStEnthalpyOfVaporiz(double stEnthalpyOfVaporiz) {
		// TODO Auto-generated method stub

	}
	
	public class Builder {
		
	}

}
