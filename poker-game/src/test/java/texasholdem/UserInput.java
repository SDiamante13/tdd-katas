package texasholdem;

import java.io.InputStream;
import java.util.Scanner;

class UserInput {

    private final InputStream inputStream;

    public UserInput(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String read() {
        return new Scanner(inputStream).nextLine();
    }
}
