package wrimsv2.solver;

import wrimsv2.components.ControlData;
import wrimsv2.solver.Gurobi.GurobiSolver;

public class CloseCurrentSolver {
	public CloseCurrentSolver(String currentSolver){
		if (currentSolver.equalsIgnoreCase("XA") || currentSolver.equalsIgnoreCase("XALOG")) {
			ControlData.xasolver.close();
		}else if (currentSolver.equalsIgnoreCase("Gurobi")){
			GurobiSolver.dispose();
		}else if (currentSolver.equalsIgnoreCase("Cbc")){
			CbcSolver.close();
			if (ControlData.cbc_debug_routeXA || ControlData.cbc_debug_routeCbc) {ControlData.xasolver.close();}
		}
	}
}
