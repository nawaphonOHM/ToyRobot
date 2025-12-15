package nawaphon.play.exceptions;


public class PlaceCommandNotFoundException extends RuntimeException {
    public PlaceCommandNotFoundException() {
        super("Place command not found.");
    }
}
