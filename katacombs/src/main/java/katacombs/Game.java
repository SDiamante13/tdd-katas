package katacombs;

import java.util.Scanner;

public class Game {

    private final World world;

    public Game(World world) {
        this.world = world;
    }

    public void play() {
        System.out.println(world.playerLocation());
        do {
            String userInput = new Scanner(System.in).nextLine();
            String[] inputArgs = userInput.split(" ");
            String response = world.respond(Action.valueOf(inputArgs[0]), inputArgs[1]);
            System.out.println(response);
        } while (true);
    }
}
