package es.escuelait.mastermind.views.console;

import es.escuelait.mastermind.controllers.StartController;
import es.escuelait.mastermind.utils.Console;

import static es.escuelait.mastermind.views.Message.TITLE;

public class StartView {

    public void interact(StartController startController) {
        Console.getInstance().write(TITLE.getMessage());
        startController.next();
    }
}
