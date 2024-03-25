package entity;

public class NotEnoughStockException extends Exception {
    public NotEnoughStockException(String mensaje) {
        super(mensaje);
    }
}
