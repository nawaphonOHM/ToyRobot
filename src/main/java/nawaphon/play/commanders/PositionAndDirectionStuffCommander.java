package nawaphon.play.commanders;


import nawaphon.play.enums.Direction;
import nawaphon.play.enums.Turn;
import nawaphon.play.pojos.DirectionNode;
import nawaphon.play.pojos.Position;
import nawaphon.play.pojos.SimplePair;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

public class PositionAndDirectionStuffCommander {

    private final Position positionModule;

    private DirectionNode currentDirection;

    private int moveXDirection = 0;
    private int moveYDirection = 0;

    public PositionAndDirectionStuffCommander(@NonNull SimplePair<Position, DirectionNode> currentInformation) {
        final var initialDirection = currentInformation.right();

        this.positionModule = currentInformation.left();
        this.currentDirection = initialDirection;

        computeMoveXAndMoveY(initialDirection.getDirection());
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

    public void move() {
        final var validX = Math.min(5, Math.max(0, positionModule.getX() + moveXDirection));
        final var validY = Math.min(5, Math.max(0, positionModule.getY() + moveYDirection));

        positionModule.setX(validX);
        positionModule.setY(validY);
    }

    public void turn(@NonNull Turn where) {

        switch (where) {
            case LEFT -> currentDirection = currentDirection.getLeft();
            case RIGHT -> currentDirection = currentDirection.getRight();
        }

        computeMoveXAndMoveY(currentDirection.getDirection());


    }
}
