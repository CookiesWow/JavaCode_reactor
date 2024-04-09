package ru.qdts.xtooc.model.reactor;
import java.io.*;

public class Euler {

	
		double func(double z, double P, double nA0, double A1, double Ea1, double A2, double Ea2,  double temp, double V,
				 double p1, double p2, double p3)
	    {
			double k1 = Arenius.calculate(A1, Ea1, temp);
			double k2 = Arenius.calculate(A2, Ea2, temp);
			
			return (((V * k1 * Math.pow((nA0 - 2 * P), 2)) / (Math.pow((((nA0 - 2 * P)/p1) + P/p2 + P/p3), 2))) -
	        		V * k2 * Math.pow(P, 2) / (Math.pow((((nA0 - 2 * P)/p1) + P/p2 + P/p3), 2)));
	    }
	 
	   
	    public void euler(double z0, double P, double h, double z, double nA0,double A1, double Ea1, double A2, double Ea2,  double temp, double V,
				 double p1, double p2, double p3)
	    {
	    	
	    	double tempo = -0;
	        while (z0 < z) {
	        	tempo = P;
	            P = P + h * func(z, P,  nA0, A1, Ea1, A2, Ea2, temp,  V,
	   				  p1,  p2,  p3);
	          
	         
	            z0 = z0 + h;
	        }
	        
	        
	        
	        
	        System.out.println("Метод Эйлера: значение P в точке z равно: "  +  P);
	        
	        
	    }
	 
	    
	}
	 
	