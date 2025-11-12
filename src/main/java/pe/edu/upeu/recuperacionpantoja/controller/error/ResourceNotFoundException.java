package pe.edu.upeu.recuperacionpantoja.controller.error;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
