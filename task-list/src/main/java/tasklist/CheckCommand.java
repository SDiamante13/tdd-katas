package tasklist;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

class CheckCommand implements Command {

    private final PrintWriter out;
    private final Map<String, List<Task>> tasks;

    CheckCommand(PrintWriter out, Map<String, List<Task>> tasks) {
        this.out = out;
        this.tasks = tasks;
    }

    @Override
    public void execute(String... commands) {
        String idString = commands[0];
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(true);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
