package nl.novi.techiteasy.exceptions;

public class InvalidTelevisionNameException extends RuntimeException {
    //Als de methode niet gebruikt wordt moet je hem dan weglaten?
    public InvalidTelevisionNameException() {
        super("Invalid television name");
    }

    public InvalidTelevisionNameException(String message) {
        super(message);
    }
}
