package es.escuelait.mastermind.views.console;

import es.escuelait.mastermind.controllers.Controller;
import es.escuelait.mastermind.controllers.ProposeCombinationController;
import es.escuelait.mastermind.controllers.ResumeController;
import es.escuelait.mastermind.controllers.StartController;
import es.escuelait.mastermind.views.View;

public class ConsoleView extends View {

    private final StartView startView;
    private final GameView gameView;
    private final ResumeView resumeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.gameView = new GameView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(ProposeCombinationController proposeCombinationController) {
        gameView.interact(proposeCombinationController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeView.interact(resumeController);
    }
}
