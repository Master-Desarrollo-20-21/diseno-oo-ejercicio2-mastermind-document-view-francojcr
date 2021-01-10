package es.escuelait.mastermind.controllers;

import es.escuelait.mastermind.models.Game;
import es.escuelait.mastermind.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
    
	@Override
	public boolean isNull() {
		return false;		
	}    

}
