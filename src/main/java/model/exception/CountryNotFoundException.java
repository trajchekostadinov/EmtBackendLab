package model.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super("Country with id " + id + " not found");
    }
}