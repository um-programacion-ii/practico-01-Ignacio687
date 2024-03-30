package entity.customExceptions;

public class InvalidIngredientException extends Exception {
    public InvalidIngredientException(String mensaje) {
        super(mensaje);
    }
}
