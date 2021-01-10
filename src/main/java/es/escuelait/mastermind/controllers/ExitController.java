package es.escuelait.mastermind.controllers;

import es.escuelait.mastermind.models.Game;
import es.escuelait.mastermind.models.State;

public class ExitController extends Controller{

	public ExitController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
	}

	@Override
	public boolean isNull() {
		return true;		
	}

}
