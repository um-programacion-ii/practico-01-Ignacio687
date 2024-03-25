package entity;

public class Ingrediente {
    private String nombre;
    private Integer cantidad;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, Integer cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    public String sacar(int amount) throws NotEnoughStockException {
        if (amount <= this.cantidad) {
            this.cantidad = this.cantidad - amount;
            return String.format("Remaining units: %d", this.cantidad);
        } else {
            throw new NotEnoughStockException("Not enough remaining units, available: "+this.cantidad);
        }
    }
}