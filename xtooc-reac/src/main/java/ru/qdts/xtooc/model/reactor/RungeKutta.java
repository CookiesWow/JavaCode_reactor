package ru.qdts.xtooc.model.reactor;

public class RungeKutta {

	
	 double differential(double z, double P, double nA0, double A1, double Ea1, double A2, double Ea2, double temp, double V,
	 double p1, double p2, double p3)
	    {
		 
		double k1 = Arenius.calculate(A1, Ea1, temp);
		double k2 = Arenius.calculate(A2, Ea2, temp);
		
	        return (((V * k1 * Math.pow((nA0 - 2 * P), 2)) / (Math.pow((((nA0 - 2 * P)/p1) + P/p2 + P/p3), 2))) -
	        		V * k2 * Math.pow(P, 2) / (Math.pow((((nA0 - 2 * P)/p1) + P/p2 + P/p3), 2)));
	        
	    }
	     
	     public double rungeKutta(double z0, double P0, double z, double h, double nA0, double A1, double Ea1, double A2, double Ea2, double temp, double V,
	    		 double p1, double p2, double p3)
	    {
	    	RungeKutta d1 = new RungeKutta();
	        
	    	//double Pm = 0;
	    	
	        int n = (int)((z - z0) / h);
	        
	 
	        double kr1, kr2, kr3, kr4;
	 
	       // double m = 1;
	        double P = P0;
	     //   while (m > 0.00001) {
	        for (int i = 1; i <= n; i++)
	        {
	            
	            kr1 = h * (d1.differential(z0, P, nA0, A1, Ea1, A2, Ea2, temp, V,
	            		 p1, p2, p3));
	            kr2 = h * (d1.differential(z0 + 0.5 * h, P + 0.5 *  kr1, nA0,  A1, Ea1, A2, Ea2, temp,  V,
	            		  p1,  p2,  p3));
	            kr3 = h * (d1.differential(z0 + 0.5 * h, P + 0.5 * kr2, nA0,  A1, Ea1, A2, Ea2, temp,  V,
	            		  p1,  p2,  p3));
	            kr4 = h * (d1.differential(z0 + h, P +  kr3, nA0,  A1, Ea1, A2, Ea2, temp,  V,
	            		  p1,  p2,  p3));
	 
	            
	            P = P + (1.0 / 6.0) * (kr1 + 2 * kr2 + 2 * kr3 + kr4);
	           // m = Math.abs(P - Pm)/P;
	           // Pm = P;
	            
	            
	            z0 = z0 + h;
	        }
	       
	       // h = h/2;
	   //     }
	       
	       // System.out.print("\nМетод Рунгге-Кута: значение h в точке z равно: "  + h);
			return P;
	       
	    }
}
