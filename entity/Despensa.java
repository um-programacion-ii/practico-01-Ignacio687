package entity;

import entity.customExceptions.InvalidIngredientException;
import entity.customExceptions.NotEnoughStockException;

public class Despensa {
    private Ingrediente[] ingredientes;

    public Despensa() {
        this.ingredientes = new Ingrediente[0];
    }

    public Despensa(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Ingredientes en despensa:" + this.showIngredientes();
    }

    public StringBuilder showIngredientes() {
        StringBuilder ingredientes = new StringBuilder();
        for (int counter = 0; counter < this.ingredientes.length; counter++) {
            if (counter < this.ingredientes.length-1) {
                ingredientes.append("\n").append(this.ingredientes[counter]).append(", ");
            } else {
                ingredientes.append("\n").append(this.ingredientes[counter]);
            }
        }
        return ingredientes;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        try {
            Ingrediente ingredienteDisp = this.inspectIngrediente(ingrediente.getNombre());
            ingredienteDisp.setCantidad(ingredienteDisp.getCantidad()+ingrediente.getCantidad());
        } catch (InvalidIngredientException e) {
            Ingrediente[] newIngredientes = new Ingrediente[this.ingredientes.length + 1];
            System.arraycopy(this.ingredientes, 0, newIngredientes, 0, this.ingredientes.length);
            newIngredientes[this.ingredientes.length] = ingrediente;
            this.ingredientes = newIngredientes;
        }
    }

    public String getIngrediente(String name, int amount) throws NotEnoughStockException, InvalidIngredientException {
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getNombre().trim().equalsIgnoreCase(name.trim())) {
                return ingrediente.sacar(amount);
            }
        }
        throw new InvalidIngredientException("The ingredient doesn't exist.");
    }

    public Ingrediente inspectIngrediente(String name) throws InvalidIngredientException {
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getNombre().trim().equalsIgnoreCase(name.trim())) {
                return ingrediente;
            }
        }
        throw new InvalidIngredientException("The ingredient "+name+" doesn't exist.");
    }
}
