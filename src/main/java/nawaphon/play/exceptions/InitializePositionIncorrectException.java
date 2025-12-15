package nawaphon.play.exceptions;


public class InitializePositionIncorrectException extends RuntimeException {
    public InitializePositionIncorrectException() {
        super("""
                Expected Position:
                
                0 <= x <= 5
                0 <= y <= 5
                
       
                """);
    }
}
