package nawaphon.play.pojos;


import nawaphon.play.enums.Direction;

public class DirectionNode {

    private final Direction direction;

    private DirectionNode left;

    private DirectionNode right;


    public DirectionNode(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public DirectionNode getLeft() {
        return left;
    }

    public void setLeft(DirectionNode left) {
        this.left = left;
    }

    public DirectionNode getRight() {
        return right;
    }

    public void setRight(DirectionNode right) {
        this.right = right;
    }
}
