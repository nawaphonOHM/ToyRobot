package nawaphon.play.commanders;


import nawaphon.play.enums.Direction;
import nawaphon.play.pojos.DirectionNode;
import nawaphon.play.pojos.Position;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

public class PositionAndDirectionStuffCommander {

    private final Position positionModule;

    private DirectionNode currentDirection;

    private int moveXDirection = 0;
    private int moveYDirection = 0;

    public PositionAndDirectionStuffCommander(Position positionModule) {
        this.positionModule = positionModule;
    }

    @Contract(mutates = "this")
    private void computeMoveXAndMoveY (@NonNull Direction direction) {

        switch (direction) {
            case NORTH -> {
                moveYDirection = 1;
                moveXDirection = 0;
            }
            case WEST -> {
                moveYDirection = 0;
                moveXDirection = -1;
            }
            case SOUTH -> {
                moveYDirection = -1;
                moveXDirection = 0;
            }
            case EAST -> {
                moveYDirection = 0;
                moveXDirection = 1;
            }
        }

    }
}
