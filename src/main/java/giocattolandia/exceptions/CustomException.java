package giocattolandia.exceptions;

public class CustomException {

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }

        public NotFoundException() {}
    }
}
