package ru.qdts.xtooc.model.phase;

import java.util.ArrayList;
import java.util.List;

import ru.qdts.xtooc.model.component.Component;
import ru.qdts.xtooc.model.mixture.Composition;
import ru.qdts.xtooc.model.mixture.Mixture;
import static ru.qdts.xtooc.model.phase.PhaseSystem.Phase;

public class BasePhaseSystem implements PhaseSystem {

	private List<Component> components = null;
	private List<Phase> phases = null;
	
	public class BasePhase implements Phase{
		private Composition phaseComposition;
		private double temperature;
		private double pressure;
		
		BasePhase(Composition phaseComposition, double temperature, double pressure) {
			super();
			this.phaseComposition = phaseComposition;
			this.temperature = temperature;
			this.pressure = pressure;
		}
		
		
	}
	
	protected BasePhaseSystem() {
		super();
	}
	
	protected BasePhaseSystem(List<Component> components, List<Phase> phases) {
		this.components = components;
		this.phases = phases;
	}
	
	public static PhaseSystem create(Mixture mixture, double temperature, double pressure) {
		BasePhaseSystem ps = new BasePhaseSystem();
		Phase p = ps.new BasePhase(mixture.getComposition(), temperature, pressure);
		ps.components = mixture.getComponents();
		ps.phases = new ArrayList<>();
		ps.phases.add(p);
		
		return ps;
	}
}
