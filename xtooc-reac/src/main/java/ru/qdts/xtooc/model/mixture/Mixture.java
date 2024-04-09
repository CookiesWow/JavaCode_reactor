package ru.qdts.xtooc.model.mixture;

import java.util.List;

import ru.qdts.xtooc.model.component.Component;

public interface Mixture {

    double getMixDensity(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixViscosity(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixIntEnthalpyOfVap (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixIntEnthalpyOfLiq (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixEnthalpyOfVaporiz(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixPressure (double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixBoilingTemperature (double pressure) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixHeatCapacityOfVap(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;
    double getMixHeatCapacityOfLiq(double temp) throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException;

    int getNumComp();

    Composition getComposition();

    List<Component> getComponents();
}
