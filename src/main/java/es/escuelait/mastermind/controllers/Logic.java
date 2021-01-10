package es.escuelait.mastermind.controllers;

import es.escuelait.mastermind.models.Game;
import es.escuelait.mastermind.models.State;
import es.escuelait.mastermind.models.StateValue;

import java.util.Map;

import static es.escuelait.mastermind.models.StateValue.EXIT;

public class Logic {

    private final Map<StateValue, Controller> controllers;
    private final Game game;
    private final State state;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = Map.of(
                StateValue.INITIAL, new StartController(this.game, this.state),
                StateValue.IN_GAME, new ProposeCombinationController(this.game, this.state),
                StateValue.RESUME, new ResumeController(this.game, this.state),
                StateValue.EXIT, new ExitController(this.game, this.state)
        );
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

    public boolean isExit() {
        return this.controllers.get(this.state.getValueState()).isNull();
    }

}
