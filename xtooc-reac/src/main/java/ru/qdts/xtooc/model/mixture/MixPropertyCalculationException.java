package ru.qdts.xtooc.model.mixture;

@SuppressWarnings("serial")
public class MixPropertyCalculationException extends MixtureException {
	private String propertyName;
	
	public MixPropertyCalculationException(String propName) {
		super("Property [" + propName + "] can't be calculated");
		propertyName = propName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
}
