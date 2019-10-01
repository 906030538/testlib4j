package ru.ifmo.testlib.verifiers;

import ru.ifmo.testlib.*;

import java.io.*;

/**
 * A result adapter for domjudge.
 *
 * @author Misaka Honoka
 */
public class DOMJudgeResultAdapter implements ResultAdapter {
    /**
     * Applies the optional command-line arguments to the verifier.
     *
     * @param args the extra arguments to the result adapter.
     */
    public void initArgs(String[] args) {}

    /**
     * Returns the exit code for the specified quit type. It may differ from platform to platform.
     *
     * @param outcome the quit type.
     * @return the exit code.
     */
    public int getExitCodeFor(Outcome outcome) {
        switch (outcome.getType()) {
            case OK:   return 42;
            case WA:   return 43;
            case PE:
            case FAIL:
            default:   return 43;
        }
    }

    /**
     * Prints an outcome message to the specified writer.
     *
     * @param outcome   the outcome.
     * @param logWriter the writer to print to.
     * @param console   <tt>true</tt> if the writer prints on console, <tt>false</tt> if to file.
     */
    public void printMessage(Outcome outcome, PrintWriter logWriter, boolean console) {
        String message = outcome.getComment();
        if (console) {
            switch (outcome.getType()) {
                case FAIL:
                    logWriter.print("FAIL ");
                    break;
                case PE:
                    logWriter.print("wrong output format ");
                    break;
                case OK:
                    logWriter.print("ok ");
                    break;
                case WA:
                    logWriter.print("wrong answer ");
                    break;
            }
            logWriter.println(message);
        } else {
            logWriter.println(message);
        }
    }
}
