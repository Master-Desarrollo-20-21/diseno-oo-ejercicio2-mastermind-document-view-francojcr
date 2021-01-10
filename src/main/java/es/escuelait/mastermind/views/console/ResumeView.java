package es.escuelait.mastermind.views.console;

import es.escuelait.mastermind.controllers.ResumeController;
import es.escuelait.mastermind.utils.Console;
import es.escuelait.mastermind.views.Message;

public class ResumeView {

    public void interact(ResumeController resumeController) {
        if (isResume()) {
            resumeController.reset();
        } else {
            resumeController.finish();
        }
    }

    public boolean isResume() {
        char input;
        do {
            input = Console.getInstance().readChar(Message.RESUME.getMessage());
        } while (!isValidInput(input));
        return 'y' == input;
    }

    private boolean isValidInput(char input) {
        return 'y' == input || 'n' == input;
    }


}
