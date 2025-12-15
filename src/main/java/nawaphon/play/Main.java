package nawaphon.play;


import nawaphon.play.commanders.PositionAndDirectionStuffCommander;
import nawaphon.play.commanders.UntilCommander;
import nawaphon.play.enums.Turn;
import nawaphon.play.exceptions.InitializePositionIncorrectException;
import nawaphon.play.exceptions.PlaceCommandNotFoundException;
import nawaphon.play.pojos.SimplePair;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Toy Robot!");

        var isInitialized = false;

        PositionAndDirectionStuffCommander commander = null;

        final var scanner = new Scanner(System.in);


        while (true) {

            final var input = scanner.nextLine();

            if (!isInitialized) {
                try {
                    final var result = UntilCommander.findAndSetPosition(input);

                    commander = new PositionAndDirectionStuffCommander(

                            new SimplePair<>(
                                    result.left(),
                                    UntilCommander.makeDirectionGraphAndReturnInitialDirection(result.right())
                            )

                    );

                    isInitialized = true;

                } catch (PlaceCommandNotFoundException | InitializePositionIncorrectException e) {
                    System.err.println(e.getMessage());
                }

                continue;
            }

            if (input.equals("MOVE")) {
                commander.move();

                continue;
            }

            if (input.equals("LEFT") || input.equals("RIGHT")) {

                commander.turn(Turn.valueOf(input));

                continue;

            }

            if (input.equals("REPORT")) {
                break;
            }

        }

        final var current = commander.getCurrentInformation();

        System.out.printf("Output: %d,%d,%s%n",
                current.left().getX(),
                current.left().getY(),
                current.right().getDirection().name()
        );


    }

}