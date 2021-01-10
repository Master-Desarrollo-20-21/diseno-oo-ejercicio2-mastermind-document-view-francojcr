package es.escuelait.mastermind.views;

import es.escuelait.mastermind.controllers.Controller;
import es.escuelait.mastermind.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public abstract void interact(Controller controller);

}
