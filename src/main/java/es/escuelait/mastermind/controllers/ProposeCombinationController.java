package es.escuelait.mastermind.controllers;

import es.escuelait.mastermind.models.Attempt;
import es.escuelait.mastermind.models.Color;
import es.escuelait.mastermind.models.Error;
import es.escuelait.mastermind.models.Game;
import es.escuelait.mastermind.models.ProposedCombination;
import es.escuelait.mastermind.models.State;

import java.util.ArrayList;
import java.util.List;

public class ProposeCombinationController extends Controller {

    public ProposeCombinationController(Game game, State state) {
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
	
    public int getAttemptsCount() {
        return game.getAttemptsCount();
    }

    public List<Attempt> getPlayedAttempts() {
        return game.getPlayedAttempts();
    }

    public void matchCombination(ProposedCombination proposedCombination) {
        game.playCombination(proposedCombination);
    }

    public boolean isContinuePlaying() {
        return game.isContinuePlaying();
    }

    public boolean isWinnerGame() {
        return game.isWinnerGame();
    }

    public Error checkIfValidProposedCombination(String proposedCombinationCode) {
        if (proposedCombinationCode.isBlank()) {
            return Error.WRONG_PROPOSED_COMBINATION_LENGTH;
        }
        if (proposedCombinationCode.length() != ProposedCombination.COMBINATION_SIZE) {
            return Error.WRONG_PROPOSED_COMBINATION_LENGTH;
        }
        if (!isValidColors(proposedCombinationCode)) {
            return Error.WRONG_PROPOSED_COMBINATION_COLORS;
        }
        if (duplicateColors(proposedCombinationCode)) {
            return Error.DUPLICATE_PROPOSED_COMBINATION_COLORS;
        }
        return Error.NULL;
    }

    private boolean duplicateColors(String proposedCombinationCode) {
        List<Character> uniqueColors = new ArrayList<>();
        for (char colorCode : proposedCombinationCode.toCharArray()) {
            if (uniqueColors.contains(colorCode)) {
                return true;
            }
            uniqueColors.add(colorCode);
        }
        return false;
    }

    private boolean isValidColors(String proposedCombination) {
        for (char colorCode : proposedCombination.toCharArray()) {
            if (!Color.isValidColor(colorCode)) {
                return false;
            }
        }
        return true;
    }

    public void finish() {
        super.next();
    }
}
