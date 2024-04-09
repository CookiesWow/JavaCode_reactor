package ru.qdts.xtooc.model.mixture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

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

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class CompositionTest {
	static Composition comp = null;
	
	static Composition comp1 = null;
	static Composition comp2 = null;
	static Composition comp3 = null;
	static Composition comp4 = null;
	static Composition comp5 = null;
	static Composition comp6 = null;
	
	static BaseMixture mix1 = null;
	static BaseMixture mix2 = null;
	static BaseMixture mix3 = null;
	static BaseMixture mix4 = null;
	static BaseMixture mix5 = null;
	static BaseMixture mix6 = null;
	
	static BaseComponent bc_DE;
	static BaseComponent bc_E;
	static BaseComponent bc_W;
 
	@BeforeAll
  static void createMixture() throws MixtureException, UnnormolizedCompositionException {
	  bc_DE = new BaseComponent("Диэтиловый эфир", 1, 2, 3, 4, 5,
			new DensityCalculatorImpl(70.6361, 0.26782, 466.578, 0.28243),
			new ViscosityCalculatorImpl(-5.13316 ,1286.03, 55.8587),
			new EnthalpyOfVaporizCalculatorImpl(14204.2, 1.6416, -1.7394, 0.5831), 
			new BoilingTemperatureCalculatorImpl(16.0828, 2511.29, -41.94), 
			new PressureCalculatorImpl(16.0828, 2511.29, -41.94), 
			new HeatCapacityOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
			new HeatCapacityOfLiquidImpl(44400, 1301, -5.5, 0.008763, 0), 
			new IntegralEnthalpyOfVaporImpl(0, 0, 0, 0), 
			new IntegralEnthalpyOfLiquidImpl());
	  bc_E = new BaseComponent("Этанол", 1, 2, 3, 4, 5,
			new DensityCalculatorImpl(99.3974, 0.310729, 513.18, 0.305143),
			new ViscosityCalculatorImpl(-7.37146, 2770.25, 74.6787),
			new EnthalpyOfVaporizCalculatorImpl(15723.5, 1.1905, -1.7666, 1.0012), 
			new BoilingTemperatureCalculatorImpl(18.9119, 3803.98, -41.68), 
			new PressureCalculatorImpl(18.9119, 3803.98, -41.68), 
			new HeatCapacityOfVaporImpl(2.153, 0.05113, -0.00002004, 0.000000000328), 
			new HeatCapacityOfLiquidImpl(102640, -139.63, -0.030341, 0.0020386, 0), 
			new IntegralEnthalpyOfVaporImpl(2.153, 0.05113, -0.00002004, 0.000000000328), 
			new IntegralEnthalpyOfLiquidImpl());
	  bc_W = new BaseComponent("Вода", 1, 2, 3, 4, 5,
			new DensityCalculatorImpl(0.14395, 0.0112, 649.727 , 0.05107),
			new ViscosityCalculatorImpl(-3.7188, 578.919, -137.546),
			new EnthalpyOfVaporizCalculatorImpl(13518.7, 0.61204, -0.6257, 0.3988), 
			new BoilingTemperatureCalculatorImpl(18.3036, 3816.44, -46.13), 
			new PressureCalculatorImpl(18.3036, 3816.44, -46.13), 
			new HeatCapacityOfVaporImpl(7.701, 0.0004595, 0.000002521, -0.000000000859), 
			new HeatCapacityOfLiquidImpl(276370, -2090.1, 8.125, -0.01412, 0.0000093701), 
			new IntegralEnthalpyOfVaporImpl(7.701, 0.0004595, 0.000002521, -0.000000000859), 
			new IntegralEnthalpyOfLiquidImpl());
	
	List<Component> lc = new ArrayList<Component>();
	lc.add(bc_DE);
	lc.add(bc_E);
	lc.add(bc_W);
	
	double [] c_DE_E_D = {0.81, 0.19, 0.0};
	double [] c_DE_W_D = {0.01, 0.0, 0.99};
	double [] c_E_W_D = {0.0, 0.5, 0.5}; 
	double [] c_DE_E_V = {0.63, 0.37, 0.0};
	double [] c_DE_W_V = {0.01, 0.0, 0.99};
	double [] c_E_W_V = {0.0, 0.8, 0.2}; 
	
	comp1 = Composition.of(c_DE_E_D);
	comp2 = Composition.of(c_DE_W_D);
	comp3 = Composition.of(c_E_W_D);
	comp4 = Composition.of(c_DE_E_V);
	comp5 = Composition.of(c_DE_W_V);
	comp6 = Composition.of(c_E_W_V);
	
//	MixDensityCalculatorImpl mdc = new MixDensityCalculatorImpl();
//    MixViscosityCalculatorImpl mvc = new MixViscosityCalculatorImpl();
//    mix1.setMixDensityCalc(mdc);
//    mix2.setMixDensityCalc(mdc);
//    mix3.setMixDensityCalc(mdc);
//    mix4.setMixViscosityCalc(mvc);
//    mix5.setMixViscosityCalc(mvc);
////    mix6.setMixViscosityCalc(mvc);
    
	
    mix1 = new BaseMixture(lc, comp1, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
    mix2 = new BaseMixture(lc, comp2, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
    mix3 = new BaseMixture(lc, comp3, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
    mix4 = new BaseMixture(lc, comp4, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
    mix5 = new BaseMixture(lc, comp5, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
    mix6 = new BaseMixture(lc, comp6, new MixDensityCalculatorImpl(), new MixViscosityCalculatorImpl(), 
    		new MixEntalpyOfVaporizationCalculatorImpl(), new MixBoilingTemperatureCalculatorImpl(), 
    		new MixPressureCalculatorImpl(), new MixHeatCapacityOfVapCalculatorImpl(), new MixHeatCapacityOfLiqCalculatorImpl(), 
    		new MixIntEntalpyOfVaporCalculatorImpl(), new MixIntEntalpyOfLiquidCalculatorImpl());
    
    
 }
    static final double DENSITY_AT_DE_E = 720;
    static final double DENSITY_AT_DE_W = 990.5;
    static final double DENSITY_AT_E_W = 927;
    static final double VISCOSITY_AT_DE_E = 0.315;
    static final double VISCOSITY_AT_DE_W = 0.995;
    static final double VISCOSITY_AT_E_W = 1.701;
 
	
	@Test
	@Order(1)
	void createComposition() {
		double [] dArray = {0.2, 0.3, 0.5};
		try {
			comp = Composition.of(dArray);
		} catch (UnnormolizedCompositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(comp);
	}
	
	@Test
	@Order(2)
	void iterateTest() {
		double s = 0;
		for(Double val : comp) {
			s += val;
		}
		assertEquals(1.0, s);
	}
	
	@Test
	@Order(3)
	void getTest() {
		assertEquals(0.2, comp.get(0));
		assertEquals(0.3, comp.get(1));
		assertEquals(0.5, comp.get(2));
	}
	
	@Test
	@Order(4)
	void unmodifiebleTest() {
		ListIterator<Double> i = comp.iterator();
		assertThrows(UnsupportedOperationException.class, () -> i.add(0.9));
		assertThrows(UnsupportedOperationException.class, () -> i.set(0.8));
	}
	
	@Test
	@Order(5)
	void createUnnormolizedComposition() {
		double [] dArray = {0.2, 0.3, 0.4};
		assertThrows(UnnormolizedCompositionException.class, () -> Composition.of(dArray));
		
	}
	
	@Test
	@Order(6)
	void calculateDensityTest() throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException  {
		double dens1 = mix1.getMixDensity(293.15);
	    double dens2 = mix2.getMixDensity(293.15);
	    double dens3 = mix3.getMixDensity(293.15);
	    try {
	    	dens1 = mix1.getMixDensity(293.15);
	    	dens2 = mix2.getMixDensity(293.15);
	    	dens3 = mix3.getMixDensity(293.15);
		    } catch (MixPropertyCalculationException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (MixPropertyCalculatorNotDefinedException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
	    assertTrue(Math.abs((mix1.getMixDensity(298.15)-DENSITY_AT_DE_E)/DENSITY_AT_DE_E) < 1, "Density1 = " );
	    assertTrue(Math.abs((mix2.getMixDensity(298.14)-DENSITY_AT_DE_W)/DENSITY_AT_DE_W) < 1, "Density2 = " );
	    assertTrue(Math.abs((mix3.getMixDensity(293.15)-DENSITY_AT_E_W)/DENSITY_AT_E_W) < 1, "Density3 = " );
	    System.out.println("DE_E " + mix1.getMixDensity(298.15) + " DE_W "  + mix2.getMixDensity(298.14) + " E_W " + mix3.getMixDensity(293.15));
	  }
	@Test
	@Order(6)
	void calculateViscosityTest() throws MixPropertyCalculationException, MixPropertyCalculatorNotDefinedException {
	    double visc1 = mix4.getMixViscosity(298.14);
	    double visc2 = mix5.getMixViscosity(298.14);
	    double visc3 = mix6.getMixViscosity(293.15);
	    try {
	      visc1 = mix4.getMixViscosity(298.14);
	      visc2 = mix5.getMixViscosity(298.14);
	      visc3 = mix6.getMixViscosity(298.15);
	    } catch (MixPropertyCalculationException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (MixPropertyCalculatorNotDefinedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    assertTrue(Math.abs((visc1-VISCOSITY_AT_DE_E)/VISCOSITY_AT_DE_E) < 1, "Viscosity = " + visc1);
	    assertTrue(Math.abs((visc2-VISCOSITY_AT_DE_W)/VISCOSITY_AT_DE_W) < 1, "Viscosity = " + visc2);
	    assertTrue(Math.abs((visc3-VISCOSITY_AT_E_W)/VISCOSITY_AT_E_W) < 1, "Viscosity = " + visc3);
	    System.out.println("DE_E " + visc1 + " DE_W "  + visc2 + " E_W " + visc3);
	  }
}

