package es.escuelait.mastermind.models;

public class Attempt {

    private final ProposedCombination proposedCombination;
    private final SecretCombination secretCombination;

    public Attempt(ProposedCombination proposedCombination, SecretCombination secretCombination) {
        this.proposedCombination = proposedCombination;
        this.secretCombination = secretCombination;
    }

    public boolean isWinner() {
        return secretCombination.isEqual(proposedCombination);
    }

    public int getWhites() {
        return secretCombination.getWhites(proposedCombination);
    }

    public int getBlacks() {
        return secretCombination.getBlacks(proposedCombination);
    }

    @Override
    public String toString() {
        return proposedCombination.getColorsCode();
    }

}
