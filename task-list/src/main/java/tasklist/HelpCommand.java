package tasklist;

import java.io.PrintWriter;

class HelpCommand implements Command {

    private final PrintWriter out;

    HelpCommand(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void execute(String... commands) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
