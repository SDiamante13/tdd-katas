package tasklist;

import java.io.PrintWriter;

class ErrorCommand implements Command {

    private final PrintWriter out;

    ErrorCommand(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void execute(String... commands) {
        String command = commands[0];
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
