package es.escuelait.mastermind.views.console;


import es.escuelait.mastermind.controllers.ProposeCombinationController;
import es.escuelait.mastermind.models.ProposedCombination;
import es.escuelait.mastermind.utils.Console;
import es.escuelait.mastermind.views.Message;

public class GameView {

    private final ProposedCombinationView proposedCombinationView;

    public GameView() {
        this.proposedCombinationView = new ProposedCombinationView();
    }

    public void interact(ProposeCombinationController proposeCombinationController) {
        do {
            ProposedCombination proposedCombination = proposedCombinationView.interact(proposeCombinationController);
            proposeCombinationController.matchCombination(proposedCombination);
        } while (proposeCombinationController.isContinuePlaying());
        proposeCombinationController.finish();
        
        if (proposeCombinationController.isWinnerGame()) {
            Console.getInstance().writeln(Message.WIN_MESSAGE.getMessage());
        } else {
            Console.getInstance().writeln(Message.LOST_MESSAGE.getMessage());
        }
    }
}
