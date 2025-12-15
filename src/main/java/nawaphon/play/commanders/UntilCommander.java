package nawaphon.play.commanders;


import nawaphon.play.enums.Direction;
import nawaphon.play.pojos.DirectionNode;
import org.jspecify.annotations.NonNull;

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
}
