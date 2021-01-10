package es.escuelait.mastermind.views.console;

import es.escuelait.mastermind.controllers.ProposeCombinationController;
import es.escuelait.mastermind.models.Attempt;
import es.escuelait.mastermind.models.Error;
import es.escuelait.mastermind.models.ProposedCombination;
import es.escuelait.mastermind.utils.Console;
import es.escuelait.mastermind.views.ErrorView;
import es.escuelait.mastermind.views.Message;

import static es.escuelait.mastermind.views.Message.PROPOSE_COMBINATION;

public class ProposedCombinationView {

    public ProposedCombination interact(ProposeCombinationController proposeCombinationController) {
        Console.getInstance().writeln(String.format(Message.ATTEMPTS_COUNT.getMessage(), proposeCombinationController.getAttemptsCount()));
        Console.getInstance().writeln(Message.SECRET_COMBINATION_HIDDEN.getMessage());
        for (Attempt attempt : proposeCombinationController.getPlayedAttempts()) {
            Console.getInstance()
                    .writeln(String.format(Message.ATTEMPT.getMessage(), attempt.toString(), attempt.getBlacks(), attempt.getWhites()));
        }
        return readProposedCombination(proposeCombinationController);
    }	
	
    private ProposedCombination readProposedCombination(ProposeCombinationController proposeCombinationController) {
        String proposedCombinationCode = "";
        Error error;
        do {
            proposedCombinationCode = Console.getInstance().readString(PROPOSE_COMBINATION.getMessage());
            Console.getInstance().writeln();
            Console.getInstance().writeln();
            error = proposeCombinationController.checkIfValidProposedCombination(proposedCombinationCode);
            ErrorView.of(error).writeln();
        } while (!error.isNull());
        return new ProposedCombination(proposedCombinationCode.toCharArray());
    }

}
