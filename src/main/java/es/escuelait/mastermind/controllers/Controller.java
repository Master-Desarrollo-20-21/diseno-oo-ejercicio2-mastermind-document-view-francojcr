package es.escuelait.mastermind.controllers;

import es.escuelait.mastermind.models.Game;
import es.escuelait.mastermind.models.State;

public abstract class Controller {

    protected Game game;
    protected State state;

    public Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public abstract void accept(ControllerVisitor controllerVisitor);
    
    public abstract boolean isNull();

    public void next() {
        this.state.next();
    }


}
