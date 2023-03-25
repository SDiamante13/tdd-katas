package tasklist;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class Projects {
    private final Map<String, List<Task>> tasks;

    Projects(Map<String, List<Task>> tasks) {
        this.tasks = tasks;
    }

    public void addProject(String projectName) {
        tasks.put(projectName, new ArrayList<>());
    }

    public List<Task> projectTasks(String projectName) {
        return tasks.get(projectName);
    }
}
public class AddCommand implements Command {

    private final Map<String, List<Task>> tasks;
    private Projects projects;
    private final PrintWriter out;

    // this is a counter which assigns the task id
    private static long lastId = 0;

    public AddCommand(PrintWriter out, Map<String, List<Task>> tasks, Projects projects) {
        this.tasks = tasks;
        this.out = out;
        this.projects = projects;
    }

    @Override
    public void execute(String... commands) {
        String[] subcommandRest = commands[0].split(" ", 2);
        String subcommand = subcommandRest[0];


        if (subcommand.equals("project")) {
            tasks.put(subcommandRest[1], new ArrayList<Task>());
            projects.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            List<Task> projectTasks = tasks.get(projectTask[0]);
            List<Task> projectTasksNew = projects.projectTasks(projectTask[0]);
            if (projectTasks == null || projectTasksNew == null) {
                out.printf("Could not find a project with the name \"%s\".", projectTask[0]);
                out.println();
                return;
            }
            projectTasks.add(new Task(++lastId, projectTask[1], false));
        }
    }
}
