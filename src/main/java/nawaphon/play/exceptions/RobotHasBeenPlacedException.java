package nawaphon.play.exceptions;


public class RobotHasBeenPlacedException extends RuntimeException {
    public RobotHasBeenPlacedException() {
        super("Detected Duplicated Place Command which is not allowed.");
    }
}
