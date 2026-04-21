package dev.gunjan.BookMyShow.exception;

public class SelectedSeatsNotAvailableException extends RuntimeException {
    public SelectedSeatsNotAvailableException(String message) {
        super(message);
    }
}
