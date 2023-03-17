package texasholdem;

import java.io.InputStream;
import java.util.Scanner;

class UserInput {

    private final InputStream inputStream;

    public UserInput(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String read() {
        System.out.println("B?, C?, F?");
        return new Scanner(inputStream).nextLine();
    }
}
