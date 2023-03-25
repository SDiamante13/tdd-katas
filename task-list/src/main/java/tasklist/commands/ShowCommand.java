package tasklist.commands;

import tasklist.Command;
import tasklist.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ShowCommand implements Command {

    private final PrintWriter out;
    private Map<String, List<Task>> tasks;

    public ShowCommand(PrintWriter out, Map<String, List<Task>> tasks) {
        this.out = out;
        this.tasks = tasks;
    }

    @Override
    public void execute(String... commands) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
