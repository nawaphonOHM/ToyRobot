package nawaphon.play.commanders;


import nawaphon.play.enums.Direction;
import nawaphon.play.exceptions.InitializePositionIncorrectException;
import nawaphon.play.exceptions.PlaceCommandNotFoundException;
import nawaphon.play.pojos.DirectionNode;
import nawaphon.play.pojos.Position;
import nawaphon.play.pojos.SimplePair;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import java.util.regex.Pattern;

public abstract class UntilCommander {

    public static DirectionNode makeDirectionGraphAndReturnInitialDirection(@NonNull Direction initialDirection) {

        final var northNode = new DirectionNode(Direction.NORTH);
        final var southNode = new DirectionNode(Direction.SOUTH);
        final var eastNode = new DirectionNode(Direction.EAST);
        final var westNode = new DirectionNode(Direction.WEST);


        northNode.setLeft(westNode);
        northNode.setRight(eastNode);

        eastNode.setLeft(northNode);
        eastNode.setRight(southNode);

        southNode.setLeft(eastNode);
        southNode.setRight(westNode);

        westNode.setLeft(southNode);
        westNode.setRight(northNode);

        return switch (initialDirection) {
            case NORTH -> northNode;
            case SOUTH -> southNode;
            case EAST -> eastNode;
            case WEST -> westNode;
        };

    }

    @Contract("_ -> new")
    public static @NonNull SimplePair<Position, Direction> findAndSetPosition(String input) throws PlaceCommandNotFoundException, InitializePositionIncorrectException {
        final var placeRegex = "PLACE (?<xPosition>\\d+),(?<yPosition>\\d+),(NORTH|SOUTH|EAST|WEST)";
        final var regexPattern = Pattern.compile(placeRegex);

        final var matcher = regexPattern.matcher(input);

        var found = matcher.find();

        if (!found) {
            throw new PlaceCommandNotFoundException();
        }

        final var x = Integer.parseInt(matcher.group("xPosition"));
        final var y = Integer.parseInt(matcher.group("yPosition"));

        if (0 > x || x > 5) {
            throw new InitializePositionIncorrectException();
        }

        if (0 > y || y > 5) {
            throw new InitializePositionIncorrectException();
        }

        return new SimplePair<>(

                new Position(
                        x,
                        y
                ),

                Direction.valueOf(matcher.group(3))
        );


    }
}
