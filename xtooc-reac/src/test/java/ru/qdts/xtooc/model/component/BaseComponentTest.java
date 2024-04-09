package ru.qdts.xtooc.model.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.qdts.xtooc.model.component.BaseComponent.BoilingTemperatureCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.DensityCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.IntegralEnthalpyOfLiquidCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.IntegralEnthalpyOfVaporCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.EnthalpyOfVaporizationCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.HeatCapacityOfVaporCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.PressureCalculator;
import ru.qdts.xtooc.model.component.BaseComponent.ViscosityCalculator;

public class BaseComponentTest {
	
	static final String NAME_DE = "Diethyl ether";
	static final double MOLEC_MASS_DE = 74.12; //г/моль
	static final double ST_TEMP_BOIL_DE = 34.43; //C°
	static final double TEMP_CRIT_DE = 466.7; //K
	static final double ST_ENTHALPY_DE = 30352.0139082158; //Дж/моль
	static final double ST_ENTHALPY_OF_VAPORIZATION_DE = 27100; //Дж/моль
	static final double DENSITY_CALCULATOR_DE = 707.8; //г/см^3
	static final double VISCOSITY_CALCULATOR_DE = 0.224; //мПа*с
	static final double ENTALPY_OF_VAPORIZ_CALCULATOR_DE = 27100; //Дж/моль
	static final double BOILING_TEMPERATURE_CALCULATOR_DE = 34.43; //C°
	static final double PRESSURE_CALCULATOR_DE = 437; //мм. рт. ст. при 20C° 
	static final double HEAT_CAPACITY_OF_VAPOR_DE = 115.15;//Дж/(моль·K)
	static final double HEAT_CAPACITY_OF_LIQUID_DE = 175.6;//Дж/(моль·K)
	static final double HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE = 30352.0139082158;//Кдж/моль
	static final double ENTALPY_OF_LIQUID_CALCULATOR_DE = 0;//Кдж/моль
	static BaseComponent bc_DE;
	static final String NAME_E = "Ethanol";
	static final double MOLEC_MASS_E = 46.07; //г/моль
	static final double ST_TEMP_BOIL_E = 78.25; //C°
	static final double TEMP_CRIT_E = 514.0; //K
	static final double ST_ENTHALPY_E = 38487.7392444669; //Дж/моль
	static final double ST_ENTHALPY_OF_VAPORIZATION_E = 42300; //Дж/моль
	static final double DENSITY_CALCULATOR_E = 785.2; //г/см^3
	static final double VISCOSITY_CALCULATOR_E = 1.074; //мПа*с
	static final double ENTALPY_OF_VAPORIZ_CALCULATOR_E = 42300; //Дж/моль
	static final double BOILING_TEMPERATURE_CALCULATOR_E = 78.25; //C°
	static final double PRESSURE_CALCULATOR_E = 43.9; //мм. рт. ст. при 20C° 
	static final double HEAT_CAPACITY_OF_VAPOR_E = 68.15; //Дж/(моль·K)
	static final double HEAT_CAPACITY_OF_LIQUID_E = 113.00; //Дж/(моль·K)
	static final double HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_E = 38487.7392444669; //Кдж/моль
	static final double ENTALPY_OF_LIQUID_CALCULATOR_E = 0; //Кдж/кмоль
	static BaseComponent bc_E;
	static final String NAME_W = "Water";
	static final double MOLEC_MASS_W = 18.02; //г/моль
	static final double ST_TEMP_BOIL_W = 100.0; //C°
	static final double TEMP_CRIT_W = 647.1; //C°
	static final double ST_ENTHALPY_W = 40650.5664646560; //Кдж/моль
	static final double ST_ENTHALPY_OF_VAPORIZATION_W = 43980; //Кдж/моль
	static final double DENSITY_CALCULATOR_W = 997; //г/см^3
	static final double VISCOSITY_CALCULATOR_W = 0.890; //мПа*с
	static final double ENTALPY_OF_VAPORIZ_CALCULATOR_W = 43567; //Дж/моль
	static final double BOILING_TEMPERATURE_CALCULATOR_W = 100.0; //C°
	static final double PRESSURE_CALCULATOR_W = 17.5; //мм. рт. ст. при 20C° 
	static final double HEAT_CAPACITY_OF_VAPOR_W = 34.10; //Дж/(моль·K)
	static final double HEAT_CAPACITY_OF_LIQUID_W = 75.68; //Дж/(моль·K)
	static final double HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_W = 40650.5664646560; //Кдж/моль
	static final double ENTALPY_OF_VAPOR_CALCULATOR_W = 158.9263421; //Кдж/моль
    static final double ENTALPY_OF_LIQUID_CALCULATOR_W = 6.541822722; //Кдж/моль
    static BaseComponent bc_W;
	
	@BeforeAll
	static void createComponent() {
		
		bc_DE = new BaseComponent(NAME_DE, MOLEC_MASS_DE, TEMP_CRIT_DE, ST_TEMP_BOIL_DE, ST_ENTHALPY_DE, ST_ENTHALPY_OF_VAPORIZATION_DE,
				new DensityCalculatorImpl(70.6361, 0.26782, 466.578, 0.28243),
				new ViscosityCalculatorImpl(-5.13316 ,1286.03, 55.8587),
				new EnthalpyOfVaporizCalculatorImpl(14204.2, 1.6416, -1.7394, 0.5831), 
				new BoilingTemperatureCalculatorImpl(16.0828, 2511.29, -41.94), 
				new PressureCalculatorImpl(16.0828, 2511.29, -41.94), 
				new HeatCapacityOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
				new HeatCapacityOfLiquidImpl(44400, 1301, -5.5, 0.008763, 0), 
				new IntegralEnthalpyOfVaporImpl(5.117, 0.08022, -0.00002473, -0.000000002235), 
				new IntegralEnthalpyOfLiquidImpl());
		bc_E = new BaseComponent(NAME_E, MOLEC_MASS_E, TEMP_CRIT_E, ST_TEMP_BOIL_E,  ST_ENTHALPY_E, ST_ENTHALPY_OF_VAPORIZATION_E,
				new DensityCalculatorImpl(99.3974, 0.310729, 513.18, 0.305143),
				new ViscosityCalculatorImpl(-7.37146, 2770.25, 74.6787),
				new EnthalpyOfVaporizCalculatorImpl(15723.5, 1.1905, -1.7666, 1.0012), 
				new BoilingTemperatureCalculatorImpl(18.9119, 3803.98, -41.68), 
				new PressureCalculatorImpl(18.9119, 3803.98, -41.68), 
				new HeatCapacityOfVaporImpl(2.153, 0.05113, -0.00002004, 0.000000000328), 
				new HeatCapacityOfLiquidImpl(102640, -139.63, -0.030341, 0.0020386, 0), 
				new IntegralEnthalpyOfVaporImpl(2.153, 0.05113, -0.00002004, 0.000000000328), 
				new IntegralEnthalpyOfLiquidImpl());
		bc_W = new BaseComponent(NAME_W, MOLEC_MASS_W, TEMP_CRIT_W, ST_TEMP_BOIL_W,  ST_ENTHALPY_W, ST_ENTHALPY_OF_VAPORIZATION_W,
				new DensityCalculatorImpl(0.14395, 0.0112, 649.727 , 0.05107),
				new ViscosityCalculatorImpl(-3.7188, 578.919, -137.546),
				new EnthalpyOfVaporizCalculatorImpl(13518.7, 0.61204, -0.6257, 0.3988), 
				new BoilingTemperatureCalculatorImpl(18.3036, 3816.44, -46.13), 
				new PressureCalculatorImpl(18.3036, 3816.44, -46.13), 
				new HeatCapacityOfVaporImpl(7.701, 0.0004595, 0.000002521, -0.000000000859), 
				new HeatCapacityOfLiquidImpl(276370, -2090.1, 8.125, -0.01412, 0.0000093701), 
				new IntegralEnthalpyOfVaporImpl(7.701, 0.0004595, 0.000002521, -0.000000000859), 
				new IntegralEnthalpyOfLiquidImpl());
	}
	
	@Test
	void getNameTest() {
		assertTrue(NAME_DE.equals(bc_DE.getName()));
		assertTrue(NAME_E.equals(bc_E.getName()));
		assertTrue(NAME_W.equals(bc_W.getName()));
	}
	
	@Test
	void getMolecMassTest() {
		assertEquals(MOLEC_MASS_DE, bc_DE.getMolecularMass());
		assertEquals(MOLEC_MASS_E, bc_E.getMolecularMass());
		assertEquals(MOLEC_MASS_W, bc_W.getMolecularMass());
	}
	
	@Test
	void getTempCriticalTest() {
		assertEquals(TEMP_CRIT_DE, bc_DE.getTempCritical());
		assertEquals(TEMP_CRIT_E, bc_E.getTempCritical());
		assertEquals(TEMP_CRIT_W, bc_W.getTempCritical());
	}
	
	@Test
	void getStTempBoilTest() {
		assertEquals(ST_TEMP_BOIL_DE, bc_DE.getStBoilTemp());
		assertEquals(ST_TEMP_BOIL_E, bc_E.getStBoilTemp());
		assertEquals(ST_TEMP_BOIL_W, bc_W.getStBoilTemp());
	}
	@Test
	void getStEnthalpyTest() {
		assertEquals(ST_ENTHALPY_DE, bc_DE.getStEnthalpy());
		assertEquals(ST_ENTHALPY_E, bc_E.getStEnthalpy());
		assertEquals(ST_TEMP_BOIL_W, bc_W.getStBoilTemp());
	}
	
	@Test
	void getStEnthalpyOfVaporizTest() {
		assertEquals(ST_ENTHALPY_OF_VAPORIZATION_DE, bc_DE.getStEnthalpyOfVaporiz());
		assertEquals(ST_ENTHALPY_OF_VAPORIZATION_E, bc_E.getStEnthalpyOfVaporiz());
		assertEquals(ST_ENTHALPY_OF_VAPORIZATION_W, bc_W.getStEnthalpyOfVaporiz());
	}
	@Test 
	void getDensityTest() throws PropertyCalculatorNotDefinedException{
		boolean D = false;
		if ((Math.abs(DENSITY_CALCULATOR_DE - bc_DE.getDensity(298))/DENSITY_CALCULATOR_DE) < 0.01 & 
				(Math.abs(DENSITY_CALCULATOR_E - bc_E.getDensity(298))/DENSITY_CALCULATOR_E)< 0.01 &
		(Math.abs(DENSITY_CALCULATOR_W - bc_W.getDensity(298))/DENSITY_CALCULATOR_W)< 0.01){
			 D = true;
			 System.out.println("Density DE " +bc_DE.getDensity(298) + " E " + bc_E.getDensity(298) + " W " + bc_W.getDensity(298));

		}
		assertTrue(D);
	}
	@Test 
	void getViscosityTest() throws PropertyCalculatorNotDefinedException{
		//assertEquals(VISCOSITY_CALCULATOR_DE, bc_DE.getViscosity(298));
		boolean V = false;
		if ((Math.abs(VISCOSITY_CALCULATOR_DE - bc_DE.getViscosity(298))/VISCOSITY_CALCULATOR_DE) < 0.01 & 
				(Math.abs(VISCOSITY_CALCULATOR_E - bc_E.getViscosity(298))/VISCOSITY_CALCULATOR_E)<0.01 &
		(Math.abs(VISCOSITY_CALCULATOR_W - bc_W.getViscosity(298))/VISCOSITY_CALCULATOR_W)<0.01){
			 V = true;
			 System.out.println("Viscosity DE " +bc_DE.getViscosity(298) + " E " + bc_E.getViscosity(298) + " W " + bc_W.getViscosity(298));

		}
		assertTrue(V);
	}
	@Test 
	void getEnthalpyOfVaporizTest() throws PropertyCalculatorNotDefinedException{
		//assertEquals(ENTALPY_OF_VAPORIZ_CALCULATOR_DE, bc_DE.getEnthalpyOfVaporiz(298, 466.7));
		boolean EViz = false;
		if ((Math.abs(ENTALPY_OF_VAPORIZ_CALCULATOR_DE - bc_DE.getEnthalpyOfVaporiz(298))/ENTALPY_OF_VAPORIZ_CALCULATOR_DE) < 0.01 & 
				(Math.abs(ENTALPY_OF_VAPORIZ_CALCULATOR_E - bc_E.getEnthalpyOfVaporiz(298))/ENTALPY_OF_VAPORIZ_CALCULATOR_E)< 0.01 &
		(Math.abs(ENTALPY_OF_VAPORIZ_CALCULATOR_W - bc_W.getEnthalpyOfVaporiz(298))/ENTALPY_OF_VAPORIZ_CALCULATOR_W)< 0.01){
			 EViz = true;
			 System.out.println("Enthalpy Vaporiz DE " +bc_DE.getEnthalpyOfVaporiz(298) + " E " + bc_E.getEnthalpyOfVaporiz(298) + " W " + bc_W.getEnthalpyOfVaporiz(298));
		}
		assertTrue(EViz);
	}
	@Test 
	void getBoilingTemperatureTest() throws PropertyCalculatorNotDefinedException{
		boolean Tb = false;
		if ((Math.abs(293 - bc_DE.getBoilingTemperature(437))/ENTALPY_OF_VAPORIZ_CALCULATOR_DE) < 0.01 & 
				(Math.abs(293 - bc_E.getBoilingTemperature(43.9))/ENTALPY_OF_VAPORIZ_CALCULATOR_E)< 0.01 &
		(Math.abs(293 - bc_W.getBoilingTemperature(17.5))/ENTALPY_OF_VAPORIZ_CALCULATOR_W)< 0.01){
			 Tb = true;
		}
		assertTrue(Tb);
    }
	@Test 
	void getPressureTest() throws PropertyCalculatorNotDefinedException{
		//assertEquals(PRESSURE_CALCULATOR_DE, bc_DE.getPressure(298));
		boolean P = false;
		if ((Math.abs(PRESSURE_CALCULATOR_DE - bc_DE.getPressure(293))/PRESSURE_CALCULATOR_DE) < 0.01 & 
				(Math.abs(PRESSURE_CALCULATOR_E - bc_E.getPressure(293))/PRESSURE_CALCULATOR_E)< 0.01 &
		(Math.abs(PRESSURE_CALCULATOR_W - bc_W.getPressure(293))/PRESSURE_CALCULATOR_W)< 0.02){
			 P = true;
			 System.out.println("Pressure " +bc_DE.getPressure(293) + " E " + bc_E.getPressure(293) + " W " + bc_W.getPressure(293));

		}
		assertTrue(P);
    }
	@Test 
	void getHeatCapacityOfVapTest() throws PropertyCalculatorNotDefinedException{
		//assertEquals(HEAT_CAPACITY_OF_VAPOR_DE, bc_DE.getHeatCapacityOfVap(298));
		boolean Hv = false;
		if ((Math.abs(HEAT_CAPACITY_OF_VAPOR_DE - bc_DE.getHeatCapacityOfVap(310))/HEAT_CAPACITY_OF_VAPOR_DE) < 0.01 & 
				(Math.abs(HEAT_CAPACITY_OF_VAPOR_E - bc_E.getHeatCapacityOfVap(315.5))/HEAT_CAPACITY_OF_VAPOR_E)< 0.01 &
		(Math.abs(HEAT_CAPACITY_OF_VAPOR_W - bc_W.getHeatCapacityOfVap(361.77))/HEAT_CAPACITY_OF_VAPOR_W)< 0.01){
			 Hv = true;
			 System.out.println("Heat Cap V DE " +bc_DE.getHeatCapacityOfVap(310) + " E " + bc_E.getHeatCapacityOfVap(315.5) + " W " + bc_W.getHeatCapacityOfVap(361.77));
		}
		assertTrue(Hv);
    }
	@Test 
	void getHeatCapacityOfLiqTest() throws PropertyCalculatorNotDefinedException{
		//assertEquals(HEAT_CAPACITY_OF_LIQUID_DE, bc_DE.getHeatCapacityOfLiq(298));
		boolean Hl = false;
		if ((Math.abs(HEAT_CAPACITY_OF_LIQUID_DE - bc_DE.getHeatCapacityOfLiq(298))/HEAT_CAPACITY_OF_LIQUID_DE) < 0.01 & 
				(Math.abs(HEAT_CAPACITY_OF_LIQUID_E - bc_E.getHeatCapacityOfLiq(298))/HEAT_CAPACITY_OF_LIQUID_E)< 0.01 &
		(Math.abs(HEAT_CAPACITY_OF_LIQUID_W - bc_W.getHeatCapacityOfLiq(298))/HEAT_CAPACITY_OF_LIQUID_W)< 0.01){
			 Hl = true;
			 System.out.println("Heat Cap l DE " +bc_DE.getHeatCapacityOfLiq(298) + " E " + bc_E.getHeatCapacityOfLiq(298) + " W " + bc_W.getHeatCapacityOfLiq(298));
		}
		assertTrue(Hl);
		
	}
		 
		// В данном тесте сравнивались расчёты энтальпии пара в аспене с расчётами энтальпии пара проведёнными с помощью кода
	@Test 	
	void getpolEnthalpyOfVapTest_1() throws PropertyCalculatorNotDefinedException{
			boolean Hys_E_v = false;
			if ((Math.abs(HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE - bc_DE.getintEnthalpyOfVap(298))/HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE) < 1 &
			(Math.abs(HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_E - bc_E.getintEnthalpyOfVap(298))/HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE) < 1 &
			(Math.abs(HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_W - bc_W.getintEnthalpyOfVap(298))/HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE) < 1){
			Hys_E_v = true;
			System.out.println("Entalpy Vapour DE " +bc_DE.getintEnthalpyOfVap(298) + " E " + bc_E.getintEnthalpyOfVap(298) + " W " + bc_W.getintEnthalpyOfVap(298));
		}
			assertTrue(Hys_E_v);
			
	}
	
		
		// В данном тесте сравниваются энтальпии пара расчитанные разными способами
	/*	void getpolEnthalpyOfVapTest_2() throws PropertyCalculatorNotDefinedException{
			boolean E_V = false;
			if ((Math.abs(bc_E.getintEnthalpyOfVap(298, -56120) - bc_E.getpolEnthalpyOfVap(298, MOLEC_MASS_E))/bc_E.getintEnthalpyOfVap(298, -56120)) < 10 &
			(Math.abs(bc_W.getintEnthalpyOfVap(298, -57800) - bc_W.getpolEnthalpyOfLiq(298, ST_ENTHALPY_OF_VAPORIZATION_W ,MOLEC_MASS_W))/ENTALPY_OF_LIQUID_CALCULATOR_W) < 10){
			E_V = true;
		}
			assertTrue(E_V);
			
	}
	**/	
		// В данном тесте сравниваются энтальпии жидкости расчитанные разными способами
		/*void getpolEnthalpyOfLiqTest() throws PropertyCalculatorNotDefinedException{
			boolean E_L = false;
			if ((Math.abs(bc_E.getintEnthalpyOfLiq(298, -56120, ST_ENTHALPY_OF_VAPORIZATION_E) - bc_E.getpolEnthalpyOfLiq(298, ST_ENTHALPY_OF_VAPORIZATION_E, MOLEC_MASS_E))/bc_E.getintEnthalpyOfLiq(298, -56120, ST_ENTHALPY_OF_VAPORIZATION_E)) < 10 &
			(Math.abs(bc_W.getintEnthalpyOfLiq(298, -57800, ST_ENTHALPY_OF_VAPORIZATION_W) - bc_W.getpolEnthalpyOfLiq(298, ST_ENTHALPY_OF_VAPORIZATION_W ,MOLEC_MASS_W))/ENTALPY_OF_LIQUID_CALCULATOR_W) < 10){
			E_L = true;
		}
			assertTrue(E_L);
	}
	**/
		/*Test
		void getpolEnthalpyOfLiqTest_1() throws PropertyCalculatorNotDefinedException{
			boolean Hys_E_l = false;
			if ((Math.abs(HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE  - bc_DE.getpolEnthalpyOfVap(298))/HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE) < 0.1 &
			(Math.abs(HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_E - bc_E.getpolEnthalpyOfVap(298))/HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE) < 0.1 &
			(Math.abs(HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_W - ENTALPY_OF_VAPORIZ_CALCULATOR_W - bc_W.getpolEnthalpyOfVap(298))/HYSYS_ENTALPY_OF_VAPOR_CALCULATOR_DE) < 0.1){
			Hys_E_l = true;
		}
			assertTrue(Hys_E_l);
	}
**/
}
	
