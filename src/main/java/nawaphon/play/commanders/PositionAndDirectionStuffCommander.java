package nawaphon.play.commanders;


import nawaphon.play.pojos.DirectionNode;
import nawaphon.play.pojos.Position;

public class PositionAndDirectionStuffCommander {

    private final Position positionModule;

    private DirectionNode currentDirection;

    private int moveXDirection = 0;

    public PositionAndDirectionStuffCommander(Position positionModule) {
        this.positionModule = positionModule;
    }
}
