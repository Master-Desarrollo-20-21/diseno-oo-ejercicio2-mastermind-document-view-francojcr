package es.escuelait.mastermind.views;

import es.escuelait.mastermind.models.Error;
import es.escuelait.mastermind.utils.Console;

public class ErrorView {

    protected Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public static ErrorView of(Error error) {
        return new ErrorView(error);
    }

    public void writeln() {
        Console.getInstance().writeln(error.getMessage());
    }
}
