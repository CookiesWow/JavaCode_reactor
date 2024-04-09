package ru.qdts.xtooc.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ru.qdts.xtooc.model.component.BaseComponent;
import ru.qdts.xtooc.model.component.BoilingTemperatureCalculatorImpl;
import ru.qdts.xtooc.model.component.Component;
import ru.qdts.xtooc.model.component.DensityCalculatorImpl;
import ru.qdts.xtooc.model.component.EnthalpyOfVaporizCalculatorImpl;
import ru.qdts.xtooc.model.component.HeatCapacityOfLiquidImpl;
import ru.qdts.xtooc.model.component.HeatCapacityOfVaporImpl;
import ru.qdts.xtooc.model.component.IntegralEnthalpyOfLiquidImpl;
import ru.qdts.xtooc.model.component.IntegralEnthalpyOfVaporImpl;
import ru.qdts.xtooc.model.component.PressureCalculatorImpl;
import ru.qdts.xtooc.model.component.PropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.component.ViscosityCalculatorImpl;
import ru.qdts.xtooc.model.mixture.BaseMixture;
import ru.qdts.xtooc.model.mixture.Composition;
import ru.qdts.xtooc.model.mixture.MixBoilingTemperatureCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixDensityCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixEntalpyOfVaporizationCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixHeatCapacityOfLiqCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixHeatCapacityOfVapCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixIntEntalpyOfLiquidCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixIntEntalpyOfVaporCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixPressureCalculatorImpl;
import ru.qdts.xtooc.model.mixture.MixPropertyCalculationException;
import ru.qdts.xtooc.model.mixture.MixPropertyCalculatorNotDefinedException;
import ru.qdts.xtooc.model.mixture.MixViscosityCalculatorImpl;
import ru.qdts.xtooc.model.mixture.UnnormolizedCompositionException;
import ru.qdts.xtooc.model.reactor.Arenius;
import ru.qdts.xtooc.model.reactor.Euler;
import ru.qdts.xtooc.model.reactor.RungeKutta;

/**
 * Hello world!
 *
 */
public class App 
{ static Composition comp = null;
static BaseMixture mix = null;
static List<Component> compon = new ArrayList<Component>();
static BaseMixture BM_DE_E_D;
static BaseMixture BM_DE_W_D;
static BaseMixture BM_E_W_D;
static BaseMixture BM_DE_E_W;
static BaseMixture BM_DE_W_W;
static BaseMixture BM_E_W_W;

static final String NAME_DE = "Diethyl ether";
static final double MOLEC_MASS_DE = 74.12; //г/моль
static final double ST_TEMP_BOIL_DE = 34.43; //C°
static final double TEMP_CRIT_DE = 466.7; //K
static final double ST_ENTHALPY_DE = -278.0; //Дж/моль
static final double ST_ENTHALPY_OF_VAPORIZATION_DE = 27100; //Дж/моль
static final String NAME_E = "Ethanol";
static final double MOLEC_MASS_E = 46.07; //г/моль
static final double ST_TEMP_BOIL_E = 78.25; //C°
static final double TEMP_CRIT_E = 514.0; //K
static final double ST_ENTHALPY_E = 42300; //Дж/моль
static final double ST_ENTHALPY_OF_VAPORIZATION_E = 42300; //Дж/моль
static final String NAME_W = "Water";
static final double MOLEC_MASS_W = 18.02; //г/моль
static final double ST_TEMP_BOIL_W = 100.0; //C°
static final double TEMP_CRIT_W = 647.1; //C°
static final double ST_ENTHALPY_W = -285.8; //Дж/моль
static final double ST_ENTHALPY_OF_VAPORIZATION_W = 43980; //Дж/моль




static BaseComponent bc_DE = new BaseComponent(NAME_DE, MOLEC_MASS_DE, TEMP_CRIT_DE, ST_TEMP_BOIL_DE, ST_ENTHALPY_DE, ST_ENTHALPY_OF_VAPORIZATION_DE,
		new DensityCalculatorImpl(70.6361, 0.26782, 466.578, 0.28243),
		new ViscosityCalculatorImpl(-5.13316 ,1286.03, 55.8587),
		new EnthalpyOfVaporizCalculatorImpl(14204.2, 1.6416, -1.7394, 0.5831), 
		new BoilingTemperatureCalculatorImpl(16.0828, 2511.29, -41.94), 
		new PressureCalculatorImpl(16.0828, 2511.29, -41.94), 
		new HeatCapacityOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
		new HeatCapacityOfLiquidImpl(44400, 1301, -5.5, 0.008763, 0), 
		new IntegralEnthalpyOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
		new IntegralEnthalpyOfLiquidImpl());
static BaseComponent bc_E = new BaseComponent(NAME_E, MOLEC_MASS_E, TEMP_CRIT_E, ST_TEMP_BOIL_E,  ST_ENTHALPY_E, ST_ENTHALPY_OF_VAPORIZATION_E,
		new DensityCalculatorImpl(99.3974, 0.310729, 513.18, 0.305143),
		new ViscosityCalculatorImpl(-7.37146, 2770.25, 74.6787),
		new EnthalpyOfVaporizCalculatorImpl(15723.5, 1.1905, -1.7666, 1.0012), 
		new BoilingTemperatureCalculatorImpl(18.9119, 3803.98, -41.68), 
		new PressureCalculatorImpl(18.9119, 3803.98, -41.68), 
		new HeatCapacityOfVaporImpl(2.153, 0.05113, -0.00002004, 0.000000000328), 
		new HeatCapacityOfLiquidImpl(102640, -139.63, -0.030341, 0.0020386, 0), 
		new IntegralEnthalpyOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
		new IntegralEnthalpyOfLiquidImpl());
static BaseComponent bc_W = new BaseComponent(NAME_W, MOLEC_MASS_W, TEMP_CRIT_W, ST_TEMP_BOIL_W,  ST_ENTHALPY_W, ST_ENTHALPY_OF_VAPORIZATION_W,
		new DensityCalculatorImpl(0.14395, 0.0112, 649.727 , 0.05107),
		new ViscosityCalculatorImpl(-3.7188, 578.919, -137.546),
		new EnthalpyOfVaporizCalculatorImpl(13518.7, 0.61204, -0.6257, 0.3988), 
		new BoilingTemperatureCalculatorImpl(18.3036, 3816.44, -46.13), 
		new PressureCalculatorImpl(18.3036, 3816.44, -46.13), 
		new HeatCapacityOfVaporImpl(7.701, 0.0004595, 0.000002521, -0.000000000859), 
		new HeatCapacityOfLiquidImpl(276370, -2090.1, 8.125, -0.01412, 0.0000093701), 
		new IntegralEnthalpyOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
		new IntegralEnthalpyOfLiquidImpl());


 // static BaseMixture mix = new BaseMixture(null, null);
    public static void main( String[] args ) throws PropertyCalculatorNotDefinedException, UnnormolizedCompositionException, MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException, IOException
    {
    	Scanner in = new Scanner(System.in);
        System.out.print("Input temperature: ");
        double t = in.nextDouble();
        
        
    	System.out.println( "\nStart of calculation component properties:" );
		double p_A = bc_DE.getDensity(t);
		double p_B = bc_E.getDensity(t);
		double p_C = bc_W.getDensity(t);
		System.out.println("pA = " + p_A);
		System.out.println("pB = " + p_B);
		System.out.println("pC = " + p_C);
		double η_A = bc_DE.getViscosity(t);
		System.out.println("η = " + η_A);
		double Ev_A = bc_DE.getEnthalpyOfVaporiz(t);
		System.out.println("Ev = " + Ev_A);
		double Tb_A = bc_DE.getBoilingTemperature(10);
		System.out.println("Tb = " + Tb_A);
		double P_A = bc_DE.getPressure(t);
		System.out.println("P = " + P_A);
		double Hv_A = bc_DE.getHeatCapacityOfVap(t);
		System.out.println("Hv = " + Hv_A);
		double Hl_A = bc_DE.getHeatCapacityOfLiq(t);
		System.out.println("Hl = " + Hl_A);
		double int_EV_A = bc_DE.getintEnthalpyOfVap(t);
		System.out.println("int_EV = " + int_EV_A);
	    double int_EL_A = bc_DE.getintEnthalpyOfLiq(t);
		System.out.println("int_EL = " + int_EL_A);
		System.out.println("=========================================");
		
		
		
		Euler d1 = new Euler();
		RungeKutta d2 = new RungeKutta();
		System.out.println ("\nStart of calculation mixture properties:");
		System.out.print("Input reactor volume ");
        double V = in.nextDouble();
        double z0 = 0, P = 0, z = 1, h = 0.002, nA0 = 100,A1 = 1.1408E+11, Ea1 = 79630, A2 = 5.1145E+14, Ea2 = 103650, 
        		 p1 = p_B/MOLEC_MASS_E, p2 = p_A/MOLEC_MASS_DE, p3 =  p_C/MOLEC_MASS_W;
        System.out.println("\nk+ = " + Arenius.calculate(A1, Ea1, t));
        System.out.println("k- = " + Arenius.calculate(A2, Ea2, t));
        System.out.println("Метод Рунгге-Кута: значение P в точке z равно : "
                    + d2.rungeKutta(z0,  P,  z,  h,  nA0,  A1,  Ea1, A2, Ea2, t,  V,
           	    		  p1,  p2,  p3));
        
        double P0 = 0;
        d1.euler( z0,  P0,  h,  z,  nA0, A1,  Ea1,  A2,  Ea2,   t,  V,
				  p1,  p2,  p3);
        double rk = d2.rungeKutta(z0,  P,  z,  h,  nA0,  A1,  Ea1, A2, Ea2, t,  V,
 	    		  p1,  p2,  p3);
        
        
        double [] composition = { rk/nA0,(nA0 - 2*rk)/ nA0, rk/ nA0};
		comp = Composition.of(composition);
		List<Component> lc = new ArrayList<Component>();
		lc.add(bc_DE);
		lc.add(bc_E);
		lc.add(bc_W);
		mix = new BaseMixture(lc, comp, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
	    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
	    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
	    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
		System.out.println("composition: DE_E_W " + Arrays.toString(composition));
		
		System.out.println("=========================================");
		System.out.println( "\nStart of calculation reactor performance");
		System.out.println("pсм " + mix.getMixDensity(t));
		System.out.println("nсм " + mix.getMixViscosity(t));
		//System.out.println(mix.getMixIntEnthalpyOfVap(298));
		//System.out.println(mix.getMixIntEnthalpyOfLiq(298));		
		System.out.println("Ev " + mix.getMixEnthalpyOfVaporiz(t));
		System.out.println("Pсм " + mix.getMixPressure(t));
		System.out.println("Tсм " + mix.getMixBoilingTemperature(10));
		System.out.println("Hvсм " + mix.getMixHeatCapacityOfVap(t));
		System.out.println("Hlсм " + mix.getMixHeatCapacityOfLiq(t));
		in.close();
	}
}
   
