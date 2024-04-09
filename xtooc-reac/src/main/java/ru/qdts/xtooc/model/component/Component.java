package ru.qdts.xtooc.model.component;

public interface Component {

    String getName();
    double getMolecularMass();
    double getTempCritical();
    double getStBoilTemp();
    double getStEnthalpy();
    double getStEnthalpyOfVaporiz();
	
	double getDensity(double temp) throws PropertyCalculatorNotDefinedException;
    double getViscosity(double temp) throws PropertyCalculatorNotDefinedException;
    double getEnthalpyOfVaporiz(double temp) throws PropertyCalculatorNotDefinedException;
    double getBoilingTemperature(double pressure) throws PropertyCalculatorNotDefinedException;
    double getPressure (double temp) throws PropertyCalculatorNotDefinedException;
    double getHeatCapacityOfVap(double temp) throws PropertyCalculatorNotDefinedException;
    double getHeatCapacityOfLiq(double temp) throws PropertyCalculatorNotDefinedException;
    double getintEnthalpyOfVap(double temp) throws PropertyCalculatorNotDefinedException;
    double getintEnthalpyOfLiq(double temp) throws PropertyCalculatorNotDefinedException;
	
	
}
