package texasholdem;

interface Choice {

    static Choice create(String choice) {
        switch (choice.toUpperCase()) {
            case "CH":
                return new Check();
        }
        throw new IllegalArgumentException();
    }

    void execute();
    String state();
}
