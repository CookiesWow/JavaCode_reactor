package ru.qdts.xtooc.model.mixture;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Composition implements Iterable<Double>{
	
	private List<Double> values;
	
	public static Composition of(List<Double> c) throws UnnormolizedCompositionException {
		if(c.stream().mapToDouble(Double::doubleValue).sum() != 1)
			throw new UnnormolizedCompositionException();
		return new Composition(c);
	}
	
	public static Composition of(double [] c) throws UnnormolizedCompositionException {
		List<Double> dl = new ArrayList<>();
		for(double d : c)
			dl.add(d);
		return of(dl);
	}
	
	private Composition(List<Double> c) {
		values = List.copyOf(c);
	}
	
	public int getNumComp() {
		return values.size();
	}
	
	public static boolean isNormolized(List<Double> c) {
		if(c.stream().mapToDouble(Double::doubleValue).sum() != 1)
			return false;
		return true;
	}
	
	@Override
	public ListIterator<Double> iterator() {
		return (ListIterator<Double>) values.listIterator();
	}
	
	public double get(int i) {
		return values.get(i);
	}
	
}
