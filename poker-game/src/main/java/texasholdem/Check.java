package texasholdem;

public class Check implements Choice {

    private String state;

    @Override
    public void execute() {
        this.state = "CHECK";
    }

    public String state() {
        return state;
    }
}
