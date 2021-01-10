package es.escuelait.mastermind.controllers;

import es.escuelait.mastermind.models.Game;
import es.escuelait.mastermind.models.State;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
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

    public void reset() {
        this.state.reset();
        this.game.init();
    }

    public void finish() {
        this.next();
    }
}
