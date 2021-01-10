package es.escuelait.mastermind;


import es.escuelait.mastermind.views.View;
import es.escuelait.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }

}