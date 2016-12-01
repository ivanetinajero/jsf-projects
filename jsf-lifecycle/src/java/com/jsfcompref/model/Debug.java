package com.jsfcompref.model;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Debug implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent pe) {        
        System.out.println("AfterPhase: "+ pe.getPhaseId().toString());
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        System.out.println("BeforePhase: " + pe.getPhaseId().toString());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
